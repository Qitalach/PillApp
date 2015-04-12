package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class PillBox {
    private static Map<String, Pill> pills = new HashMap<String, Pill>();
    private static Map<Integer, List<Alarm>> dailySchedule = new HashMap<Integer, List<Alarm>>();

    public Map<String, Pill> getPills() {
        return Collections.unmodifiableMap(pills);
    }

    public void addPill(String pillName, Pill pill) {
        pills.put(pillName, pill);
    }

    public void addAlarm(Alarm alarm){
        if (dailySchedule.containsKey(alarm.getDayOfWeek())){
            dailySchedule.get(alarm.getDayOfWeek()).add(alarm);
        } else {
            List<Alarm> schedule = new LinkedList<Alarm>();
            schedule.add(alarm);
            dailySchedule.put(alarm.getDayOfWeek(), schedule);
        }
    }

    public List<Alarm> getAlarms(int dayOfWeek) {
        if(dailySchedule.containsKey(dayOfWeek)) {
            return dailySchedule.get(dayOfWeek);
        } else {
            return null;
        }

    }



}
