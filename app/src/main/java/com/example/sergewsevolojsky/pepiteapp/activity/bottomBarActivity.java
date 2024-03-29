package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class bottomBarActivity extends AppCompatActivity {

    private BottomBar mybottomBar;


    protected void StartBottomBar() {

        mybottomBar = (BottomBar) findViewById(R.id.bottomBar);

        //mybottomBar.setDefaultTab(R.id.tab_home);

        mybottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_home) {

                    //Intent intent = new Intent(getApplication().getApplicationContext(), MainActivity.class);
                    //startActivity(intent);

                } else if (tabId == R.id.tab_add) {

                    Intent intent = new Intent(getApplication().getApplicationContext(), CreateEventActivity.class);
                    startActivity(intent);

                } else if (tabId == R.id.tab_search) {
                    Intent intent = new Intent(getApplication().getApplicationContext(), SearchActivity.class);
                    startActivity(intent);

                }
            }
        });

    }


}
