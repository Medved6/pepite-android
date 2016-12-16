package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sergewsevolojsky.pepiteapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateEventActivity extends AppCompatActivity {

    @BindView(R.id.createEvent)
    Button create_event_button;

    @BindView(R.id.backToHome)
    Button back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        ButterKnife.bind(this);

        bindEvents();

    }





    private void bindEvents(){

        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

    }









    private void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
