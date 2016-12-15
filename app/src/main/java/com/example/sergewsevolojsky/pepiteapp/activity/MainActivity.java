package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends bottomBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void StartBottomBar(){
        super.StartBottomBar();
    }


    private void goToSportSelection() {

        Intent intent = new Intent(this, SportSelectionActivity.class);
        startActivity(intent);
    }
}
