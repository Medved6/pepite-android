package com.example.sergewsevolojsky.pepiteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.Event;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;

import java.util.ArrayList;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */

public class EventsAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<Event> events;

    public EventsAdapter(Context context) {
        this.events = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Event getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        EventsViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.event_list_item, null);
            holder = new EventsViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (EventsViewHolder) convertView.getTag();
        }

        holder.SetEvents(this.events.get(position));

        return convertView;
    }



    public void refresh(ArrayList<Event> events){
        this.events.clear();
        this.events.addAll(events);
        notifyDataSetChanged();
    }
}
