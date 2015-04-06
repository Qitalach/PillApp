package teamqitalach.pillapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

import java.util.Calendar;


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
    public void doNeutralClick(String pillname){

        final int _id = (int) System.currentTimeMillis();


        Intent intent = new Intent(getBaseContext(), AlertActivity.class);
        intent.putExtra("pill_name", pillname);

        operation = PendingIntent.getActivity(getBaseContext(), _id, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

        /** Getting a reference to the System Service ALARM_SERVICE */
        alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);
        long currtime =  System.currentTimeMillis();

        // time two minutes from now (currtime)
        long min = currtime + (long)120000;

        alarmManager.set(AlarmManager.RTC_WAKEUP, min, operation);
        Toast.makeText(getBaseContext(), "Alarm for " + pillname + " was snoozed", Toast.LENGTH_SHORT).show();

        //not sure if i need this
        this.finish();


    }
/*
place holder code allows program to react to pill being taken. currently creats a toast saying the time
med was taken. eventually this should use the pillname input string to create a history object
 */

    public void doPositiveClick(String pillname){
        Calendar taketime = Calendar.getInstance();
        int hour = taketime.get(Calendar.HOUR_OF_DAY);
        int minute = taketime.get(Calendar.MINUTE);
        Toast.makeText(getBaseContext(),  pillname + " was taken at "+ hour + ":" +minute, Toast.LENGTH_SHORT).show();

    }
}
