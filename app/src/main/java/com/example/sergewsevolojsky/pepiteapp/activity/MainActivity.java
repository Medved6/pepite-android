package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sergewsevolojsky.pepiteapp.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button button = (Button) findViewById(R.id.add_sport);
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSportSelection();

            }}));

        
        //Intent lockIntent = new Intent(this, LoginActivity.class);
        //startActivity(lockIntent);
    }


    private void goToSportSelection() {

        Intent intent = new Intent(this, SportSelectionActivity.class);
        startActivity(intent);
    }
}
