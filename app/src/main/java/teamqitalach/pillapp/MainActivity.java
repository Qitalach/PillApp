package teamqitalach.pillapp;

import Model.Pill;
import Model.PillBox;
import teamqitalach.pillapp.adapter.TabsAdapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener{

    private ViewPager tabsviewPager;
    private TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());

        tabsviewPager.setAdapter(mTabsAdapter);

        getSupportActionBar().setTitle("Pill Reminder");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        String todayString = new SimpleDateFormat("EEE, MMM d").format(today);
        String tomorrowString = new SimpleDateFormat("EEE, MMM d").format(tomorrow);

        Tab historytab = getSupportActionBar().newTab().setTabListener(this);
        Tab todaytab = getSupportActionBar().newTab().setTabListener(this);
        Tab tomorrowtab = getSupportActionBar().newTab().setTabListener(this);

        TextView tt1 = new TextView(this);
        tt1.setText(Html.fromHtml("<b>HISTORY</b>"));
        tt1.setTextColor(Color.WHITE);
        tt1.setGravity(Gravity.CENTER);
        //tt1.setTypeface(null, Typeface.BOLD);
        tt1.setHeight(200);
        historytab.setCustomView(tt1);

        TextView tt2 = new TextView(this);
        tt2.setText(Html.fromHtml("<b>TODAY</b><br><small>" + todayString + "</small>"));
        tt2.setTextColor(Color.WHITE);
        tt2.setGravity(Gravity.CENTER);
        //tt2.setTypeface(null, Typeface.BOLD);
        tt2.setHeight(200);
        todaytab.setCustomView(tt2);

        TextView tt3 = new TextView(this);
        tt3.setText(Html.fromHtml("<b>TOMORROW</b><br><small>" + tomorrowString + "</small>"));
        tt3.setTextColor(Color.WHITE);
        tt3.setGravity(Gravity.CENTER);
        //tt3.setTypeface(null, Typeface.BOLD);
        tt3.setHeight(200);
        tomorrowtab.setCustomView(tt3);

        getSupportActionBar().addTab(historytab);
        getSupportActionBar().addTab(todaytab);
        getSupportActionBar().addTab(tomorrowtab);

        getSupportActionBar().setSelectedNavigationItem(1);

        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        PillBox pillbox = new PillBox();
        System.out.println("------------------" + pillbox.getPills(this));
        for(Pill pill: pillbox.getPills(this)){
            String name = pill.getPillName();
            System.out.println(name);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            sendSetting();
            return true;
        }

        if (id == R.id.action_add) {
            sendAdd();
            return true;
        }

        if (id == R.id.action_edit) {
            sendEdit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab selectedtab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        tabsviewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    public void sendAdd() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
        finish();
    }

    public void sendSetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
        finish();
    }

    public void sendEdit() {
        Intent intent = new Intent(this, PillBoxActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        return;
    }

}

