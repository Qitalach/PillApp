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

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
        Collections.sort(alarms);
    }

    public void addHistory(History history) { histories.add(history); }

    public long getPillId() {
        return pillId;
    }

    public void setPillId(long pillID) {
        this.pillId = pillID;
    }
}
