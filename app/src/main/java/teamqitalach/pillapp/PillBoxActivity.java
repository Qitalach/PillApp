package teamqitalach.pillapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import Model.Alarm;
import Model.Pill;
import Model.PillBox;
import teamqitalach.pillapp.adapter.ExpandableListAdapter;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class PillBoxActivity extends ActionBarActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_box);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        try {
            prepareListData();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pill_box, menu);
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


    /*
     * Preparing the list data
     */
    private void prepareListData() throws URISyntaxException {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        PillBox pillbox = new PillBox();
        List<Pill> pills = pillbox.getPills(this);

//        Set<String> pills = pillMap.keySet();

        for (Pill pill: pills){
            String name = pill.getPillName();


            listDataHeader.add(name);
            List<String> times = new ArrayList<String>();
            List<Alarm> alarms = pillbox.getAlarmByPill(this.getBaseContext(), name);
            for (Alarm alarm :alarms){
                System.out.print(daysList(alarm));

                String time = alarm.getStringTime() + daysList(alarm);
                boolean hasTime= false;




                for (String listTime: times){
                    if (time.equals(listTime)){

                        hasTime = true;
                    }
                }
                if (!hasTime){
                    times.add(time);
                }


            }
            listDataChild.put(name, times);

        }


    }

    private String daysList(Alarm alarm){
        String days = "";
        for (int i = 0; i<7; i++){
            days += " ";
            if (alarm.getDayOfWeek()[i] ){
                if (i==0){days += "S";}
                else if(i==1){days+= "M";}
                else if(i==2){days += "T";}
                else if (i==3){days += "W";}
                else if(i==4){days += "T";}
                else if(i==5){days += "F";}
                else{days+="S";}

            }
        }
        System.out.println( " days= " + days);
        return days;
    }

    @Override
    public void onBackPressed() {
        Intent returnHome = new Intent(getBaseContext(), MainActivity.class);
        startActivity(returnHome);
        finish();
    }

}
