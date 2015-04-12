package teamqitalach.pillapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Model.History;
import Model.Pill;
import Model.PillBox;


public class AlertActivity extends FragmentActivity {

    private AlarmManager alarmManager;
    private PendingIntent operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Creating an Alert Dialog Window */
        AlertAlarm alert = new AlertAlarm();

        /** Opening the Alert Dialog Window. This will be opened when the alarm goes off */
        alert.show(getSupportFragmentManager(), "AlertAlarm");

    }

    /*
    THis method is called when the user presses the "remind me later". The method is given the name of the pill (not a pill object) and
    creates a new (nonrepeating) alarm which will go off in 2 minutes.
    most of this method was taken from the code charles wrote for addactivity. Because i copied a lot i don't
    know if its as efficient as it could be
     */
    public void doNeutralClick(String pillName){

        final int _id = (int) System.currentTimeMillis();
        final long minute = 60000;
        long snoozeLength = 2;
        long currTime = System.currentTimeMillis();
        long min = currTime + minute * snoozeLength;

        Intent intent = new Intent(getBaseContext(), AlertActivity.class);
        intent.putExtra("pill_name", pillName);

        operation = PendingIntent.getActivity(getBaseContext(), _id, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

        /** Getting a reference to the System Service ALARM_SERVICE */
        alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);


        alarmManager.set(AlarmManager.RTC_WAKEUP, min, operation);
        Toast.makeText(getBaseContext(), "Alarm for " + pillName + " was snoozed.", Toast.LENGTH_SHORT).show();

        //not sure if i need this
        this.finish();

    }
/*
place holder code allows program to react to pill being taken. currently creats a toast saying the time
med was taken. eventually this should use the pillname input string to create a history object
 */

    public void doPositiveClick(String pillName){
        PillBox pillBox = new PillBox();
        Pill pill = pillBox.getPills().get(pillName);
        History history = new History();

        Calendar takeTime = Calendar.getInstance();
        Date date = takeTime.getTime();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

        int hour = takeTime.get(Calendar.HOUR_OF_DAY);
        int minute = takeTime.get(Calendar.MINUTE);
        String am_pm = (hour < 12) ? "am" : "pm";
        int year = takeTime.get(Calendar.YEAR);
        int month = takeTime.get(Calendar.MONTH);
        int day = takeTime.get(Calendar.DAY_OF_MONTH);

        history.setHourTaken(hour);
        history.setMinuteTaken(minute);
        history.setDateString(dateString);

        pill.addHistory(history);

        String stringMinute;
        if (minute < 10){
            stringMinute = "0" + minute;
        } else {
            stringMinute = "" + minute;
        }

        Toast.makeText(getBaseContext(),  pillName + " was taken at "+ hour + ":" + stringMinute + ".", Toast.LENGTH_SHORT).show();

        Intent returnHistory = new Intent(getBaseContext(), MainActivity.class);
        startActivity(returnHistory);
    }
}
