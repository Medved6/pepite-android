package com.example.sergewsevolojsky.pepiteapp.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.Event;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */

public class EventsViewHolder {

    @BindView(R.id.event_period)
    TextView event_period_text;

    @BindView(R.id.event_name)
    TextView event_name_text;

    @BindView(R.id.event_place)
    TextView event_place_text;

    public EventsViewHolder(View itemView){

        ButterKnife.bind(this, itemView);

    }

    public void SetEvents(Event event){

        event_period_text.setText(event.getPeriod().toString());
        event_name_text.setText(event.getSport().getName().toString());
        event_place_text.setText(event.getAddress().toString());

    }

}
