package com.example.sergewsevolojsky.pepiteapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.adapter.EventsAdapter;
import com.example.sergewsevolojsky.pepiteapp.adapter.SportsAdpater;
import com.example.sergewsevolojsky.pepiteapp.model.Event;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;
import com.example.sergewsevolojsky.pepiteapp.network.EventsNetwworkManager;

import java.util.ArrayList;
import java.util.Collection;

public class SearchActivity extends bottomBarActivity {

    private EventsAdapter eventsAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        StartBottomBar();



        eventsAdapter = new EventsAdapter(this);

        listView = (ListView) findViewById(R.id.search_list);
        listView.setDivider(null);




        listView.setAdapter(eventsAdapter);






        EventsNetwworkManager.getEvent(new EventsNetwworkManager.EventsResultListener()  {
            @Override
            public void onFindEvents(ArrayList<Event> events) {
                Log.e("RESERVATIONS",events.toString());

                Collection<String> filtered = Collections2.filter(list,
                        Predicates.containsPattern("How"));
                print(filtered);


                eventsAdapter.refresh(events);

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
