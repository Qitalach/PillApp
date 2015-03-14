package Model;

import java.sql.Time;
import java.util.List;

/**
 *
 * Created by Taylor Rose on 3/14/2015.
 */
public class Pill {

    private String name;
    private List<PillTime> timesForAlarm;

    public Pill(String name, List<PillTime> alarmTime){
        this.name = name;
        this.timesForAlarm = alarmTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PillTime> getTimesForAlarm() {
        return timesForAlarm;
    }

    public void setTimesForAlarm(List<PillTime> timesForAlarm) {
        this.timesForAlarm = timesForAlarm;
    }

   // public List<PillTime> pillTimesWithinRange(Time timeOne, Time timeTwo){}
}
