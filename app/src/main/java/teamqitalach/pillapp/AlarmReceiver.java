package teamqitalach.pillapp;

/**
 * Created by CharlesPK3 on 3/10/15.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, AlarmService.class);
        context.startService(service1);
    }
}
