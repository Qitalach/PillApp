package teamqitalach.pillapp.adapter;

/**
 * Created by Qinghao on 3/11/2015.
 */
import teamqitalach.pillapp.HistoryFragment;
import teamqitalach.pillapp.TodayFragment;
import teamqitalach.pillapp.TomorrowFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Tabsadapter extends FragmentPagerAdapter {

    private int TOTAL_TABS = 3;

    public Tabsadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new HistoryFragment();
            case 1:
                // Games fragment activity
                return new TodayFragment();
            case 2:
                // Movies fragment activity
                return new TomorrowFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return TOTAL_TABS;
    }

}

