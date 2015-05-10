package pillapp.ViewController.adapter;

/**
 * Created by Qinghao on 3/11/2015.
 */
import pillapp.ViewController.HistoryFragment;
import pillapp.ViewController.TodayFragment;
import pillapp.ViewController.TomorrowFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * This fragment is based on the code at
 * http://www.feelzdroid.com/2014/10/android-action-bar-tabs-swipe-views.html
 *
 * This is a customized fragment pager adapter that handles the controller of
 * the swipe tabs we use in the main page/activity.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    private int TOTAL_TABS = 3;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new HistoryFragment();
            case 1:
                return new TodayFragment();
            case 2:
                return new TomorrowFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
