package com.zahidhasan.app.prayertimeapp.services;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by DarkzGothic on 8/29/2017.
 */

public class MainNotification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(intent.getExtras().getInt("id"));

        Toast.makeText(context, "Main Notification", Toast.LENGTH_LONG).show();
    }
}
