package com.example.sergewsevolojsky.pepiteapp.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

public class SportViewHolder {

    @BindView(R.id.sport_name)
    TextView sportNameTextView;

    //@BindView(R.id.button_add_sport)
    //Button addSportButton ;


    public SportViewHolder(View itemView) {

        ButterKnife.bind(this, itemView);
    }
    

    public void SetSport(Sport sport){
        sportNameTextView.setText(sport.getName());
    }


}
