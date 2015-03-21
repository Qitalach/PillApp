package teamqitalach.pillapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

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
        getMenuInflater().inflate(R.menu.menu_today, menu);
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

    /** Called when the user clicks the History button */
    public void sendHistory(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Today button */
    public void sendToday(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TodayActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Tomorrow button */
    public void sendTomorrow(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TomorrowActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Add button */
    public void sendAdd(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

}
