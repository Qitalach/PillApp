package teamqitalach.pillapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import android.app.PendingIntent;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;

public class TodayActivity extends ActionBarActivity {

    public final static String EXTRA_MEDICINE = "teamqitalach.pillapp.MEDICINE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMedicineActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String medicine = editText.getText().toString();
        intent.putExtra(EXTRA_MEDICINE, medicine);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void sendHistory(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void sendToday(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TodayActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void sendTomorrow(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TomorrowActivity.class);
        startActivity(intent);
    }



    public void createNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Pill Reminder")
                .setContentText("It's time to take your Vitamin D!").setSmallIcon(R.drawable.abc_ab_share_pack_holo_dark)
                .setContentIntent(pIntent)
                .addAction(R.drawable.abc_ab_share_pack_holo_dark, "Snooze", pIntent)
                .addAction(R.drawable.abc_ab_share_pack_holo_dark, "Taken", pIntent)
                .addAction(R.drawable.abc_ab_share_pack_holo_dark, "Skip", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }
}
