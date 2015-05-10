package pillapp.Model;

/**
 * Created by CharlesPK3 on 4/7/15.
 *
 * This class represents each history object, an individual incident of a pill being taken.
 * Each History object contains the name of the pill it is associated with and variables
 * which represent the time and date at which the medication was taken.
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

    public String getAm_pmTaken() { return (hourTaken < 12) ? "am" : "pm"; }

    public String getDateString() { return dateString; }

    public void setDateString(String dateString) { this.dateString = dateString; }

    public String getPillName() {
        return pillName;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }
}
