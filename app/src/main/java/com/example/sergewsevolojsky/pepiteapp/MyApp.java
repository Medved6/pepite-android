package com.example.sergewsevolojsky.pepiteapp;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.sergewsevolojsky.pepiteapp.activity.LoginActivity;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.notifications.ActionsNotificationExtender;
import com.urbanairship.push.notifications.NotificationFactory;
import com.urbanairship.util.UAStringUtil;

/**
 * Created by sergewsevolojsky on 13/12/2016.
 */

public class MyApp extends Application {

    private static Context context;

    private static MyApp instance;

    private RequestQueue requestQueue;

    private String token;

    private UAirship airship;



    @Override
    public void onCreate() {
        super.onCreate();


        MyApp.instance = this;
        MyApp.context = getApplicationContext();


        requestQueue = Volley.newRequestQueue(context);
        requestQueue.start();

        UAirship.takeOff(this, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship airship) {

                MyApp.instance.setAirship(airship);

            }
        });
    }

    public static MyApp getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UAirship getAirship() { return airship; }

    public void setAirship(UAirship airship) { this.airship = airship; }
}



