package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sergewsevolojsky.pepiteapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.registerButton)
    Button register_button;

    @BindView(R.id.goToLoginButton)
    Button go_login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    @Override
    protected void onStart() {
        super.onStart();
        ButterKnife.bind(this);
        bindEvent();
    }


    private void bindEvent(){
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterClick();
            }
        });
        go_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClick();
            }
        });
    }





    private void onRegisterClick(){
        register();
    }

    private void onLoginClick(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }






    private void register(){

        Intent intent = new Intent(this, SportSelectionActivity.class);
        startActivity(intent);

    }

}
