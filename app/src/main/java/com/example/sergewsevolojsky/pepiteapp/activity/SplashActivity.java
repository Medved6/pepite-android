package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sergewsevolojsky.pepiteapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new android.os.Handler().postDelayed(
        new Runnable() {
            public void run() {
                Log.i("tag", "This'll run 300 milliseconds later");

                //Intent intent = new Intent(this, LaunchActivity.class);
                Intent intent = new Intent(SplashActivity.this, LaunchActivity.class);
                startActivity(intent);
                finish();
            }
        },
        1000);




    }
}
