package com.nathanielmorihara.ourmessenger;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nathaniel on 3/4/2017.
 */

public class OurMessengerFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here
        // If the application is in the foreground handle both data and notification messages here.
        // Also, if you intend on generating your own notifications as a a result of a received FCM
        // message, here is where that should be initiatied.
        Log.d(TAG, "RemoteMessage received: " + remoteMessage.toString());

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setContentTitle("Nathaniel - ")
                        .setContentText("Hi Jenna")
                        .setSmallIcon(R.drawable.messenger_bubble_large_white)
                        .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE);

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
