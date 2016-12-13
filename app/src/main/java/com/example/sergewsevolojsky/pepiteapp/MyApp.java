package com.example.sergewsevolojsky.pepiteapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by sergewsevolojsky on 13/12/2016.
 */

public class MyApp extends Application {

    private static Context context;

    private static MyApp instance;

    //private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();



        MyApp.instance = this;
        MyApp.context = getApplicationContext();


        //requestQueue = Volley.newRequestQueue(context);
        //requestQueue.start();
    }

    public static MyApp getInstance() {
        return instance;
    }

    //public RequestQueue getRequestQueue() {
        //return requestQueue;
    //}
}
