package Model;

import android.content.Intent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CharlesPK3 on 3/26/15.
 */
public class Alarm {
    private static List<String> alarmNameList = new LinkedList<String>();
    private static List<Intent> intentList = new LinkedList<Intent>();
    private static List<Integer> idList = new LinkedList<Integer>();
    private static List<Integer> hourList = new LinkedList<Integer>();
    private static List<Integer> minuteList = new LinkedList<Integer>();
    private static List<String> am_pmList = new LinkedList<String>();
    private static int count = 0;

    public List<String> getAlarmNameList() {
        return Collections.unmodifiableList(alarmNameList);
    }

    public void addAlarmName(String name) {
        alarmNameList.add(name);
    }

    public List<Intent> getIntentList() {
        return Collections.unmodifiableList(intentList);
    }

    public void addIntent(Intent intent) {
        intentList.add(intent);
    }

    public List<Integer> getIdList() {
        return Collections.unmodifiableList(idList);
    }

    public void addId(Integer id) {
        idList.add(id);
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public List<Integer> getHourList() {
        return Collections.unmodifiableList(hourList);
    }

    public void addHour(Integer hour) {
        hourList.add(hour);
    }

    public List<Integer> getMinuteList() {
        return Collections.unmodifiableList(minuteList);
    }

    public void addMinute(Integer minute) {
        minuteList.add(minute);
    }

    public List<String> getAm_pmList() {
        return Collections.unmodifiableList(am_pmList);
    }

    public void addAm_pm(String am_pm) {
        am_pmList.add(am_pm);
    }
}
