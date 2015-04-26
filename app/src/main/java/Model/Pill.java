package Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Pill {
    private String pillName;
    private long pillId;
    private List<Alarm> alarms = new LinkedList<Alarm>();
    private List<History> histories = new LinkedList<History>();

    public String getPillName() { return pillName; }

    public void setPillName(String pillName) { this.pillName = pillName; }

    public List<Alarm> getAlarms() { return Collections.unmodifiableList(alarms); }

    //laura modified this method so alarms are stored in order by time of day
    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
        Collections.sort(alarms);
    }

    public List<History> getHistories() { return Collections.unmodifiableList(histories); }

    public void addHistory(History history) { histories.add(history); }


    // I added this to ease updating a pill in the database. It should always
    //  be the long returned by inserting a pill in the database.
    public long getPillId() {
        return pillId;
    }

    // this is for database lookup, should only be used/set by database or PillBox methods
    public void setPillId(long pillID) {
        this.pillId = pillID;
    }
}
