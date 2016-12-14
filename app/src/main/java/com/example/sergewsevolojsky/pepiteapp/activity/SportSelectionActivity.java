package com.example.sergewsevolojsky.pepiteapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.sergewsevolojsky.pepiteapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_selection);
    }
}
