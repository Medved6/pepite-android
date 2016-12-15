package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auth0.android.Auth0;
import com.auth0.android.Auth0Exception;
import com.auth0.android.lock.AuthenticationCallback;
import com.auth0.android.lock.Lock;
import com.auth0.android.lock.LockCallback;
import com.auth0.android.lock.utils.LockException;
import com.auth0.android.result.Credentials;
import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.User;
import com.example.sergewsevolojsky.pepiteapp.network.UserNetworkManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginButton)
    Button login_button;

    @BindView(R.id.emailEditText)
    EditText email_edit_text;

    @BindView(R.id.passwordEditText)
    EditText password_edit_text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    @Override
    protected void onStart() {
        super.onStart();

        ButterKnife.bind(this);

        bindEvent();

    }



    public void bindEvent(){

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get Inputs form values
                String email_val = email_edit_text.getText().toString();
                String password_val = password_edit_text.getText().toString();

                Log.e("LOGIN","Requete Connection");

                UserNetworkManager.registerUsers(email_val, password_val, new UserNetworkManager.UserLoginResultListener() {
                    @Override
                    public void onRegisterUsers(User[] user) {

                        Toast.makeText(LoginActivity.this, "ok", Toast.LENGTH_SHORT).show();

                        connect();
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(LoginActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }



    private boolean checkEmpty(String email, String password) {



        return true;

    }







    public void connect() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
