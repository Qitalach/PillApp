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

import Model.Alarm;
import Model.PillBox;

public class TodayFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_today);

        TableRow tbrow0 = new TableRow(container.getContext());

        TextView tt1 = new TextView(container.getContext());
        tt1.setText("Pill Name");
        tt1.setTextColor(Color.WHITE);
        tt1.setGravity(Gravity.CENTER);
        tt1.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tt1);

        TextView tt2 = new TextView(container.getContext());
        tt2.setText("Time");
        tt2.setTextColor(Color.WHITE);
        tt2.setGravity(Gravity.CENTER);
        tt2.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tt2);

        stk.addView(tbrow0);

        PillBox pillBox = new PillBox();

//        for (int i = 0; i < alarm.getCount(); i++) {
//            TableRow tbrow = new TableRow(container.getContext());
//
//            TextView t1v = new TextView(container.getContext());
//            t1v.setText("VitaminD");
//            t1v.setTextColor(Color.WHITE);
//            t1v.setGravity(Gravity.CENTER);
//            tbrow.addView(t1v);
//
//            TextView t2v = new TextView(container.getContext());
//            t2v.setText("11:00pm");
//            t2v.setTextColor(Color.WHITE);
//            t2v.setGravity(Gravity.CENTER);
//            tbrow.addView(t2v);
//
//            stk.addView(tbrow);
//        }

        for (String key: pillBox.getPills().keySet()) {
            for (Alarm alarm: pillBox.getPills().get(key).getAlarms()){
                TableRow tbrow = new TableRow(container.getContext());

                TextView t1v = new TextView(container.getContext());
                t1v.setText(pillBox.getPills().get(key).getPillName());
                t1v.setTextColor(Color.WHITE);
                t1v.setGravity(Gravity.CENTER);
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
                tbrow.addView(t2v);

                stk.addView(tbrow);
            }

        }

        return rootView;
    }

}


