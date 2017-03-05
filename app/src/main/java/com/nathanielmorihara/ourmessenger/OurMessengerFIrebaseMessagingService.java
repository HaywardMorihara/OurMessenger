package com.nathanielmorihara.ourmessenger;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nathaniel on 3/4/2017.
 */

public class OurMessengerFIrebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here
        // If the application is in the foreground handle both data and notification messages here.
        // Also, if you intend on generating your own notifications as a aresult of a received FCM
        // message, here is where that should be initiatied.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
    }
}
