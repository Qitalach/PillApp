package Model;

/**
 * Created by CharlesPK3 on 4/7/15.
 */
public class History {

    private int hourTaken;
    private int minuteTaken;
    private String dateString;
    private String pillName;

    public int getHourTaken() { return hourTaken; }

    public void setHourTaken(int hourTaken) { this.hourTaken = hourTaken; }

    public int getMinuteTaken() { return minuteTaken; }

    public void setMinuteTaken(int minuteTaken) { this.minuteTaken = minuteTaken; }

    public String getAm_pmTaken() {
        String am_pmTaken = (this.hourTaken < 12) ? "am" : "pm";
        return am_pmTaken;
    }

    public String getDateString() { return dateString; }

    public void setDateString(String dateString) { this.dateString = dateString; }


    public String getPillName() {
        return pillName;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }
}
