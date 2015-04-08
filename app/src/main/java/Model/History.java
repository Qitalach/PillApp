package Model;

/**
 * Created by CharlesPK3 on 4/7/15.
 */
public class History {

    private int hourTaken;
    private int minuteTaken;
    private String am_pmTaken;
    private String dateString;

    public int getHourTaken() { return hourTaken; }

    public void setHourTaken(int hourTaken) { this.hourTaken = hourTaken; }

    public int getMinuteTaken() { return minuteTaken; }

    public void setMinuteTaken(int minuteTaken) { this.minuteTaken = minuteTaken; }

    public String getAm_pmTaken() { return am_pmTaken; }

    public void setAm_pmTaken(String am_pmTaken) { this.am_pmTaken = am_pmTaken; }

    public String getDateString() { return dateString; }

    public void setDateString(String dateString) { this.dateString = dateString; }


}
