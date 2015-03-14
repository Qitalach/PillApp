package teamqitalach.pillapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


import java.util.Calendar;


public class AddActivity extends ActionBarActivity {

    private PendingIntent pendingIntent;
    private TimePicker timePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addAlarm(View view) {

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        Calendar calendar = Calendar.getInstance();

        //calendar.set(Calendar.MONTH, 6);
        //calendar.set(Calendar.YEAR, 2013);
        //calendar.set(Calendar.DAY_OF_MONTH, 13);


        calendar.set(Calendar.HOUR_OF_DAY, timePicker1.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker1.getCurrentMinute());
        //calendar.set(Calendar.SECOND, 0);
        //TODO figure out AM and PM
        //calendar.set(Calendar.AM_PM, Calendar.PM);

        Intent myIntent = new Intent(AddActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AddActivity.this, 0, myIntent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),pendingIntent);

    }
}
