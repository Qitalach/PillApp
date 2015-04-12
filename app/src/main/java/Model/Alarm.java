package Model;

import android.content.Intent;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class Alarm {
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



}
