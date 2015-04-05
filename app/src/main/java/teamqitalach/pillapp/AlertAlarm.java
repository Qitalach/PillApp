package teamqitalach.pillapp;

/**
 * Created by CharlesPK3 on 3/21/15.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.WindowManager.LayoutParams;

public class AlertAlarm extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /** Turn Screen On and Unlock the keypad when this alert dialog is displayed */
        getActivity().getWindow().addFlags(LayoutParams.FLAG_TURN_SCREEN_ON | LayoutParams.FLAG_DISMISS_KEYGUARD);

        /** Creating a alert dialog builder */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        /** Setting title for the alert dialog */
        builder.setTitle("PillApp");

        /** Setting the content for the alert dialog */
        builder.setMessage("Did you take your medicine?");

        /** Defining an Yes button event listener */
        builder.setPositiveButton("I took it.", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /** Exit application on click OK */
                getActivity().finish();
            }
        });

        /** Defining an Snooze button event listener */
        builder.setNeutralButton("Remind Me Later.", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /** Exit application on click OK */
                getActivity().finish();
            }
        });

        /** Defining an Cancel button event listener */
        builder.setNegativeButton("I won't take it today.", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /** Exit application on click OK */
                getActivity().finish();
            }
        });

        /** Creating the alert dialog window */
        return builder.create();
    }

    /** The application should be exit, if the user presses the back button */
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().finish();
    }

}
