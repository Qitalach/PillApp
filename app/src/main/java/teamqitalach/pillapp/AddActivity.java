package teamqitalach.pillapp;

import Model.Alarm;
import Model.Pill;
import Model.PillBox;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

//http://wptrafficanalyzer.in/blog/setting-up-alarm-using-alarmmanager-and-waking-up-screen-and-unlocking-keypad-on-alarm-goes-off-in-android/
public class AddActivity extends Activity {

    private AlarmManager alarmManager;
    private PendingIntent operation;
    private int dayOfWeekList[] = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        OnClickListener setClickListener = new OnClickListener() {

            PillBox pillBox = new PillBox();

            @Override
            public void onClick(View v) {
                final int _id = (int) System.currentTimeMillis();
                int checkBoxCounter = 0;

                EditText editText = (EditText) findViewById(R.id.pill_name);
                String pill_name = editText.getText().toString();

                /** Getting a reference to TimePicker object available in the MainActivity */
                TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);

                //int year = dpDate.getYear();
                //int month = dpDate.getMonth();
                //int day = dpDate.getDayOfMonth();
                int hour = tpTime.getCurrentHour();
                int minute = tpTime.getCurrentMinute();
                String am_pm = (hour < 12) ? "am" : "pm";

                    for(int i=0; i<7; i++) {
                        if (dayOfWeekList[i] == 1 && pill_name.length() != 0) {

                            int dayOfWeek = i+1;
                            checkBoxCounter++;

                            /** This intent invokes the activity AlertActivity, which in turn opens the AlertAlarm window */
                            Intent intent = new Intent(getBaseContext(), AlertActivity.class);
                            intent.putExtra("pill_name", pill_name);


                            /** Example of retrieving intent for later usage */
                            //Bundle bundle = intent.getExtras();
                            //String pillName = bundle.getString("pill_name");

                            /** Creating a Pending Intent */
                            operation = PendingIntent.getActivity(getBaseContext(), _id+i, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

                            /** Getting a reference to the System Service ALARM_SERVICE */
                            alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);

                            /** Getting a reference to DatePicker object available in the MainActivity */
                            //DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);


                            /** Creating a calendar object corresponding to the date and time set by the user */
                            Calendar calendar = Calendar.getInstance();

                            calendar.set(Calendar.HOUR_OF_DAY, hour);
                            calendar.set(Calendar.MINUTE, minute);
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);
                            calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

                            /** Updating model */
                            if (pillBox.getPills().containsKey(pill_name)) {
                                Pill pill = pillBox.getPills().get(pill_name);
                                Alarm alarm = new Alarm();
                                alarm.setId(_id+i);
                                alarm.setIntent(intent);
                                alarm.setHour(hour);
                                alarm.setMinute(minute);
                                alarm.setDayOfWeek(dayOfWeek);
                                alarm.setPillName(pill_name);
                                pill.addAlarm(alarm);
                                pillBox.addAlarm(alarm);
                            } else {
                                Pill pill = new Pill();
                                pill.setPillName(pill_name);
                                Alarm alarm = new Alarm();
                                alarm.setId(_id+i);
                                alarm.setIntent(intent);
                                alarm.setHour(hour);
                                alarm.setMinute(minute);
                                alarm.setDayOfWeek(dayOfWeek);
                                alarm.setPillName(pill_name);
                                pill.addAlarm(alarm);
                                pillBox.addPill(pill_name, pill);
                                pillBox.addAlarm(alarm);
                            }

                            /** Converting the date and time in to milliseconds elapsed since epoch */
                            long alarm_time = calendar.getTimeInMillis();

                            /** setRepeating() lets you specify a precise custom interval--in this case,
                             20 seconds. */
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarm_time,
                                    alarmManager.INTERVAL_DAY * 7, operation);

                            /** Setting an alarm, which invokes the operation at alert_time */
                            /** Uncomment below to set alarm once (instead of having it repeat). */
                            //alarmManager.set(AlarmManager.RTC_WAKEUP, alarm_time, operation);
                        }
                    }
                /** Alert is set successfully */
                if(checkBoxCounter == 0 || pill_name.length() == 0)
                    Toast.makeText(getBaseContext(), "Please input a pill name or check at least one day!", Toast.LENGTH_SHORT).show();

                else {
                    Toast.makeText(getBaseContext(), "Alarm for " + pill_name + " is set successfully", Toast.LENGTH_SHORT).show();
                    Intent returnHome = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(returnHome);
                }
            }
        };

        OnClickListener cancelClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uncomment to allow canceling alarms
                //if (alarmManager != null)
                //    alarmManager.cancel(operation);
                finish();
            }
        };

        Button btnSetAlarm = (Button) findViewById(R.id.btn_set_alarm);
        btnSetAlarm.setOnClickListener(setClickListener);

        Button btnQuitAlarm = (Button) findViewById(R.id.btn_cancel_alarm);
        btnQuitAlarm.setOnClickListener(cancelClickListener);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }


    public void onCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_monday:
                if (checked)
                    dayOfWeekList[1] = 1;
                else
                    dayOfWeekList[1] = 0;
                break;
            case R.id.checkbox_tuesday:
                if (checked)
                    dayOfWeekList[2] = 1;
                else
                    dayOfWeekList[2] = 0;
                break;
            case R.id.checkbox_wednesday:
                if (checked)
                    dayOfWeekList[3] = 1;
                else
                    dayOfWeekList[3] = 0;
                break;
            case R.id.checkbox_thursday:
                if (checked)
                    dayOfWeekList[4] = 1;
                else
                    dayOfWeekList[4] = 0;
                break;
            case R.id.checkbox_friday:
                if (checked)
                    dayOfWeekList[5] = 1;
                else
                    dayOfWeekList[5] = 0;
                break;
            case R.id.checkbox_saturday:
                if (checked)
                    dayOfWeekList[6] = 1;
                else
                    dayOfWeekList[6] = 0;
                break;
            case R.id.checkbox_sunday:
                if (checked)
                    dayOfWeekList[0] = 1;
                else
                    dayOfWeekList[0] = 0;
                break;
        }

    }

}
