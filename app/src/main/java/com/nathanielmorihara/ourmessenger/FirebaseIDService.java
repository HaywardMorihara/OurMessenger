package com.nathanielmorihara.ourmessenger;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by Nathaniel on 3/4/2017.
 */

public class FirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";

    //TODO: PREFS gets used elsewhere
    private static final String PREFS = "FirebaseID";

    @Override
    public void onTokenRefresh() {
        //Get updated InstanceID token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        //What is 0?
        SharedPreferences idStorage = getSharedPreferences(PREFS,0);
        SharedPreferences.Editor idStorageEditor = idStorage.edit();
        //TODO: deviceId gets used elsewhere
        idStorageEditor.putString("deviceId",refreshedToken);
        idStorageEditor.commit();

        //Implement this method to send any registration to your app's servers
        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Persist token to third-party servers
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application
     *
     * @param token The new token
     */
    private void sendRegistrationToServer(String token) {
        String body = "{\"userName\":\"nathaniel\",\"id\":\""+token+"\"}";
        new RegisterTask().execute(body);
    }
}
