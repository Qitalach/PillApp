package pillapp.Model;

import java.util.Comparator;

/**
 * Created by Laura on 5/9/15.
 * This Comparator allows the pills to be alphabetized by name
 */
public class PillComparator implements Comparator<Pill> {

    @Override
    public int compare(Pill pill1, Pill pill2){

        String firstName = pill1.getPillName();
        String secondName = pill2.getPillName();
        return firstName.compareTo(secondName);
    }
}
