package com.example.sergewsevolojsky.pepiteapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.Event;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;
import com.example.sergewsevolojsky.pepiteapp.network.EventsNetwworkManager;

import java.util.ArrayList;

public class SearchActivity extends bottomBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        StartBottomBar();

        EventsNetwworkManager.getEvent(new EventsNetwworkManager.EventsResultListener()  {
            @Override
            public void onFindEvents(ArrayList<Event> events) {
                Log.e("RESERVATIONS",events.toString());


                if(!events.isEmpty()){
                    Log.i("RESERVATION", "FILL");
                } else {
                    Log.i("RESERVATION", "EMPTY");
                }
            }

            @Override
            public void onFail() {}
        });


    }

}
