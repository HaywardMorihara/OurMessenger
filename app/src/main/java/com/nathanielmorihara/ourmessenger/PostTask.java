package com.nathanielmorihara.ourmessenger;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by Nathaniel on 3/5/2017.
 */

public class PostTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... body) {
        //TODO: Error handling
        //TODO: Use a different library? Deprecated
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("https://ourmessenger.herokuapp.com"+body[0]);
        try {
            httppost.addHeader("Content-Type","application/json");
            httppost.setEntity(new StringEntity(body[1]));
            HttpResponse response = httpclient.execute(httppost);
            Log.d("PostTask", "Post request to " + body[0] + " with body: " + body[1] + " sent");
            return response.toString();
        } catch (ClientProtocolException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
