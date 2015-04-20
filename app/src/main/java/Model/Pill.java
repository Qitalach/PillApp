package Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Pill {
    private String pillName;
    private int pillId;
    private List<Alarm> alarms = new LinkedList<Alarm>();
    private List<History> histories = new LinkedList<History>();

    public String getPillName() { return pillName; }

    public void setPillName(String pillName) { this.pillName = pillName; }

    public List<Alarm> getAlarms() { return Collections.unmodifiableList(alarms); }

    public void addAlarm(Alarm alarm) { alarms.add(alarm); }

    public List<History> getHistories() { return Collections.unmodifiableList(histories); }

    public void addHistory(History history) { histories.add(history); }

    public int getPillId() {
        return pillId;
    }

    public void setPillId(int pillID) {
        this.pillId = pillID;
    }
}
