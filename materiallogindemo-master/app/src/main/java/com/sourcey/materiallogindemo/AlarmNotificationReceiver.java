package com.sourcey.materiallogindemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Alaa on 3/18/2019.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {
   /* // Notification ID to allow for future updates
    private static final int MY_NOTIFICATION_ID = 1;
    private static final String TAG = "AlarmNotification";

    // Notification Text Elements
    private final CharSequence contentTitle = "A Kind Reminder";
    private final CharSequence contentText = "Get back to studying!!";

    // Notification Action Elements
    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

    // Notification Sound and Vibration on Arrival
   private final Uri soundURI = Uri
            .parse("android.resource://qa.edu.qu.cse.cmps312.alarmcreate/"
                    + R.raw.alarm_rooster);
    private final long[] mVibratePattern = { 0, 200, 200, 300 };

    @Override
    public void onReceive(Context context, Intent intent) {

        // The Intent to be used when the user clicks on the Notification View
        mNotificationIntent = new Intent(context, SplashActivity.class);

        // The PendingIntent that wraps the underlying Intent
        mContentIntent = PendingIntent.getActivity(context, 0,
                mNotificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Build the Notification
        Notification.Builder notificationBuilder = new Notification.Builder(
                context)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setAutoCancel(true).setContentTitle(contentTitle)
                .setContentText(contentText).setContentIntent(mContentIntent)
                ;

        // Get the NotificationManager
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // Pass the Notification to the NotificationManager:
        mNotificationManager.notify(MY_NOTIFICATION_ID,
                notificationBuilder.build());

        // Log occurence of notify() call
        Log.i(TAG, "Sending notification at:"
                + DateFormat.getDateTimeInstance().format(new Date()));

    }*/
   public static String NOTIF_ID = "notification_id";
    public static String NOTIF = "notification";

    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = intent.getParcelableExtra(NOTIF);
        int id = intent.getIntExtra(NOTIF_ID, 0);
        notificationManager.notify(id, notification);

    }
}
