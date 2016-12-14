package com.example.sergewsevolojsky.pepiteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;

import java.util.ArrayList;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

public class SportsAdpater extends BaseAdapter {

    private final Context context;
    private ArrayList<Sport> sports;

    public SportsAdpater(Context context) {
        this.sports = new ArrayList<>();
        this.context = context;
    }


    @Override
    public int getCount() {
        return sports.size();
    }

    @Override
    public Sport getItem(int position) {
        return sports.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        SportViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.sport_list_item, null);
            holder = new SportViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (SportViewHolder) convertView.getTag();
        }

        holder.SetSport(sports.get(position));

        return convertView;
    }



    public void refresh(ArrayList<Sport> sports){
        this.sports.clear();
        this.sports.addAll(sports);
        notifyDataSetChanged();
    }
}
