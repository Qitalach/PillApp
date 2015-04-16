package Model;

import android.content.Intent;


import java.net.URISyntaxException;


/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Alarm implements Comparable<Alarm>{
    private int id;
    private Intent intent;
    private int hour;
    private int minute;
    private int dayOfWeek;
    private String pillName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Intent getIntent() { return intent; }

    public void setIntent(Intent intent) { this.intent = intent; }

    public int getHour() { return hour; }

    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }

    public void setMinute(int minute) { this.minute = minute; }

    public String getAm_pm() {
        String am_pm = (this.hour < 12) ? "am" : "pm";
        return am_pm;
    }

    public int getDayOfWeek() { return dayOfWeek; }

    public void setDayOfWeek(int dayOfWeek) { this.dayOfWeek = dayOfWeek; }

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

    public String getIntentForDb(){
        Intent intent = this.getIntent();
        // don't know what toURI does, or whuy int Flags is 0,
        // this method found @ http://stackoverflow.com/questions/6740578/stroing-in-intent-in-an-sqlite-database-with-android
        String databaseIntent = intent.toUri(0);

        return databaseIntent;
    }

    public void setIntentFromDB(String databaseIntent) throws URISyntaxException {
        Intent intent = Intent.parseUri(databaseIntent, 0);
        this.intent = intent;
    }


}
