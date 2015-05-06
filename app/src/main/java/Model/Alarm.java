package Model;

import android.content.Intent;


import java.net.URISyntaxException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Alarm implements Comparable<Alarm>{
    private long id; // used to hold DB id number
    private Intent intent;
    private int hour;
    private int minute;
    private String pillName;
    private List<Intent> intents = new LinkedList<Intent>();
    private List<Long> ids = new LinkedList<Long>();
    private boolean dayOfWeek[] = new boolean[7];

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public List<Intent> getIntents() { return Collections.unmodifiableList(intents); }

    public void addIntent(Intent intent) { intents.add(intent); }

    public List<Long> getIds() { return Collections.unmodifiableList(ids); }

    public boolean[] getDayOfWeek() { return dayOfWeek; }

    public void setDayOfWeek(boolean[] dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public void addId(long id) { ids.add(id); }

    public int getHour() { return hour; }

    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }

    public void setMinute(int minute) { this.minute = minute; }

    public String getAm_pm() {
        String am_pm = (this.hour < 12) ? "am" : "pm";
        return am_pm;
    }

    public String getPillName() { return pillName; }

    public void setPillName(String pillName) { this.pillName = pillName; }


    @Override
    public int compareTo(Alarm anotherAlarm) {
        if (this.getHour() < anotherAlarm.getHour()) {
            return -1;
        } else if (this.getHour() > anotherAlarm.getHour()) {
            return 1;
        } else {
            if (this.getMinute() < anotherAlarm.getMinute()) {
                return -1;
            } else if(this.getMinute() > anotherAlarm.getMinute()) {
                return 1;
            } else{
                return 0;
            }
        }

    }


    public String getStringTime(){
        int nonMilitaryHour = this.getHour()%12;
        if (nonMilitaryHour == 0){
            nonMilitaryHour=12;
        }

        //fixes a problem where times were misrepresented "8:4pm" rather than "8:04pm"
        String minute;

        if (this.getMinute() < 10){
            minute = "0" + this.getMinute();
        } else {
            minute = "" + this.getMinute();
        }

        String time = nonMilitaryHour + ":" + minute + " " + this.getAm_pm();

        return time;

    }

//    public String getIntentForDb(){
//        Intent intent = this.getIntent();
//        // don't know what toURI does, or whuy int Flags is 0,
//        // this method found @ http://stackoverflow.com/questions/6740578/stroing-in-intent-in-an-sqlite-database-with-android
//        String databaseIntent = intent.toUri(0);
//
//        return databaseIntent;
//    }
//
//    public void setIntentFromDB(String databaseIntent) throws URISyntaxException {
//        Intent intent = Intent.parseUri(databaseIntent, 0);
//        this.intent = intent;
//    }


}
