package Model;

import android.content.Context;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class PillBox {
    private DbHelper db;
    private static List<Pill> pills = new ArrayList<Pill>(); // never queried, do we even need this?
    private static Map<Integer, List<Alarm>> dailySchedule = new HashMap<Integer, List<Alarm>>();

    public List<Pill> getPills(Context c) {
        db = new DbHelper(c);
        List<Pill> allPills = db.getAllPills();
        db.close();
        return allPills;
    }

    public long addPill(Context c, Pill pill) {
        db = new DbHelper(c);
        long pillId = db.createPill(pill);
        pill.setPillId(pillId);
       // pills.add(pill);
        db.close();

        return pillId;
    }

    public Pill getPillByName(Context c, String pillName){
        db = new DbHelper(c);
        Pill wantedPill = db.getPillByName(pillName);
        db.close();
        return wantedPill;
    }

    public void addAlarm(Context c, Alarm alarm, Pill pill){
        db = new DbHelper(c);
        db.createAlarm(alarm, pill.getPillId());
        db.close();
    }

    public List<Alarm> getAlarms(Context c, int dayOfWeek) {
//        if(dailySchedule.containsKey(dayOfWeek)) {
//            return dailySchedule.get(dayOfWeek);
//        } else {
//            return null;
//        }

        db = new DbHelper(c);
        List<Alarm> daysAlarms= db.getAlarmsByDay(dayOfWeek);
        db.close();
        return daysAlarms;
    }

    public List<Alarm> getAlarmByPill (Context c, String pillName) throws URISyntaxException {
        db = new DbHelper(c);
        List<Alarm> pillsAlarms = db.getAllAlarmsByPill(pillName);
        db.close();
        return pillsAlarms;
    }

    public boolean pillExist(Context c, String pillName) {
        db = new DbHelper(c);
        for(Pill pill: this.getPills(c)) {
            if(pill.getPillName().equals(pillName))
                return true;
        }
        return false;
    }


}
