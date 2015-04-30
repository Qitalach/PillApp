package teamqitalach.pillapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import Model.Alarm;
import Model.Pill;
import Model.PillBox;

public class TodayFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_today);

        Typeface lightFont = Typeface.createFromAsset(container.getContext().getAssets(), "fonts/Roboto-Light.ttf");

        PillBox pillBox = new PillBox();

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        List<Alarm> alarms = pillBox.getAlarms(day);
//        List<Pill> pills = pillBox.getPills(container.getContext());
        List<Alarm> alarms = pillBox.getAlarms(container.getContext(), day);
        if(alarms != null) {
            for(Alarm alarm: alarms) {
                TableRow tbrow = new TableRow(container.getContext());

                TextView t1v = new TextView(container.getContext());
                t1v.setText(alarm.getPillName());
                t1v.setTextColor(Color.WHITE);
                t1v.setGravity(Gravity.CENTER);
                t1v.setPadding(30, 30, 30, 30);
                t1v.setTextSize(25);
                t1v.setTypeface(lightFont);
                tbrow.addView(t1v);

                TextView t2v = new TextView(container.getContext());

                //changes display to non military time
                int nonMilitaryHour = alarm.getHour()%12;
                if (nonMilitaryHour == 0){
                    nonMilitaryHour=12;
                }

                //fixes a problem where times were misrepresented "8:4pm" rather than "8:04pm"
                String minute;

                if (alarm.getMinute() < 10){
                    minute = "0" + alarm.getMinute();
                } else {
                    minute = "" + alarm.getMinute();
                }

                String time = nonMilitaryHour + ":" + minute + " " + alarm.getAm_pm();
                t2v.setText(time);
                t2v.setTextColor(Color.WHITE);
                t2v.setGravity(Gravity.CENTER);
                t2v.setPadding(30, 30, 30, 30);
                t2v.setTextSize(25);
                t2v.setTypeface(lightFont);
                tbrow.addView(t2v);
//
                stk.addView(tbrow);
            }
        }

        return rootView;
    }

}


