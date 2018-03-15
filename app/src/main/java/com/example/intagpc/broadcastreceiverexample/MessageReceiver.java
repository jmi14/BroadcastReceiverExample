package com.example.intagpc.broadcastreceiverexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by intag pc on 3/15/2018.
 */

public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("message");
        callNotification(context, message);
    }

    private void callNotification(Context context, String message) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("New Message");
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        Intent intent = new Intent(context,ShowMessage.class);
        intent.putExtra("message",message);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
