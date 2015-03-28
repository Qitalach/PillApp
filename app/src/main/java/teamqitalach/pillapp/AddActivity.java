package teamqitalach.pillapp;

import Model.Alarm;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

//http://wptrafficanalyzer.in/blog/setting-up-alarm-using-alarmmanager-and-waking-up-screen-and-unlocking-keypad-on-alarm-goes-off-in-android/
public class AddActivity extends Activity {

    private AlarmManager alarmManager;
    private PendingIntent operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        OnClickListener setClickListener = new OnClickListener() {

            Alarm alarm = new Alarm();

            @Override
            public void onClick(View v) {
                /** This intent invokes the activity AlertActivity, which in turn opens the AlertAlarm window */
                Intent intent = new Intent(getBaseContext(), AlertActivity.class);
                EditText editText = (EditText) findViewById(R.id.pill_name);
                String pill_name = editText.getText().toString();
                intent.putExtra("pill_name", pill_name);

                final int _id = (int) System.currentTimeMillis();

                /** Example of retrieving intent for later usage */
                //Bundle bundle = intent.getExtras();
                //String pillName = bundle.getString("pill_name");

                /** Creating a Pending Intent */
                operation = PendingIntent.getActivity(getBaseContext(), _id, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

                /** Getting a reference to the System Service ALARM_SERVICE */
                alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);

                /** Getting a reference to DatePicker object available in the MainActivity */
                DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);

                /** Getting a reference to TimePicker object available in the MainActivity */
                TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);

                int year = dpDate.getYear();
                int month = dpDate.getMonth();
                int day = dpDate.getDayOfMonth();
                int hour = tpTime.getCurrentHour();
                int minute = tpTime.getCurrentMinute();
                String am_pm = (hour < 12) ? "am" : "pm";

                /** Creating a calendar object corresponding to the date and time set by the user */
                GregorianCalendar calendar = new GregorianCalendar(year, month, day, hour, minute);

                /** Updating Alarm model */
                alarm.addAlarmName(pill_name);
                alarm.addId(_id);
                alarm.addIntent(intent);
                alarm.addCount();
                alarm.addHour(hour);
                alarm.addMinute(minute);
                alarm.addAm_pm(am_pm);

                /** Converting the date and time in to milliseconds elapsed since epoch */
                long alarm_time = calendar.getTimeInMillis();

                /** setRepeating() lets you specify a precise custom interval--in this case,
                    20 seconds. */
                //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarm_time,
                //        1000 * 20, operation);

                /** Setting an alarm, which invokes the operation at alert_time */
                /** Uncomment below to set alarm once (instead of having it repeat). */
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarm_time, operation);

                /** Alert is set successfully */
                if(pill_name.length() != 0)
                    Toast.makeText(getBaseContext(), "Alarm for " + pill_name + " is set successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Alarm is set successfully", Toast.LENGTH_SHORT).show();
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

}
