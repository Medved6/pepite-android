package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sergewsevolojsky.pepiteapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);






        //Intent intent = new Intent(this, LaunchActivity.class);
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
        finish();
    }
}
