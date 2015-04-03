package Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Pill {
    private String pillName;
    private List<Alarm> alarms = new LinkedList<Alarm>();

    public String getPillName() { return pillName; }

    public void setPillName(String pillName) { this.pillName = pillName; }

    public List<Alarm> getAlarms() { return Collections.unmodifiableList(alarms); }

    public void addAlarm(Alarm alarm) { alarms.add(alarm); }

}
