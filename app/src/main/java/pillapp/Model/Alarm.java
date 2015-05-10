package pillapp.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CharlesPK3 on 4/3/15.
 *
 * This class represents each alarm object the user creates for a pill. These alarm objects are
 * separate from the alarmManager alarms (which represent only one day a week) utilized by the app.
 * The alarm objects represents one alarm time for one pill on all of its selected days. To connect
 * with the alarmManager alarms, each alarm contains a list of these alarms' ids
 */
public class Alarm implements Comparable<Alarm>{
    private long id;  // DB id number
    private int hour; //
    private int minute;
    private String pillName;
    private List<Long> ids = new LinkedList<Long>();
    private boolean dayOfWeek[] = new boolean[7];

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public List<Long> getIds() { return Collections.unmodifiableList(ids); }

    public boolean[] getDayOfWeek() { return dayOfWeek; }

    public void setDayOfWeek(boolean[] dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public void addId(long id) { ids.add(id); }

    public int getHour() { return hour; }

    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }

    public void setMinute(int minute) { this.minute = minute; }

    public String getAm_pm() { return (hour < 12) ? "am" : "pm"; }

    public String getPillName() { return pillName; }

    public void setPillName(String pillName) { this.pillName = pillName; }

    /**
     * Overrides the compareTo() method so that alarms can be sorted by time of day from earliest to
     * latest.
     */
    @Override
    public int compareTo(Alarm anotherAlarm) {
        if (hour < anotherAlarm.getHour())
            return -1;
        else if (hour > anotherAlarm.getHour())
            return 1;
        else {
            if (minute < anotherAlarm.getMinute())
                return -1;
            else if (minute > anotherAlarm.getMinute())
                return 1;
            else
                return 0;
        }
    }

    /**
     * A helper method which returns the time of the alarm in string form
     *  hour:minutes am/pm
     */
    public String getStringTime() {
        int nonMilitaryHour = hour % 12;
        if (nonMilitaryHour == 0)
            nonMilitaryHour = 12;
        String min = Integer.toString(minute);
        if (minute < 10)
            min = "0" + minute;
        String time = nonMilitaryHour + ":" + min + " " + getAm_pm();
        return time;
    }
}
