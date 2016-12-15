package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.pepiteapp.MyApp;
import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.model.User;
import com.example.sergewsevolojsky.pepiteapp.network.UserNetworkManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    List<String> form_values = new ArrayList<String>();

    @BindView(R.id.registerButton)
    Button register_button;

    @BindView(R.id.goToLoginButton)
    Button go_login_button;


    @BindView(R.id.firstnameEditText)
    EditText first_name_input;

    @BindView(R.id.lastnameEditText)
    EditText last_name_input;

    @BindView(R.id.emailEditText)
    EditText email_input;

    @BindView(R.id.passwordEditText)
    EditText password_input;



    @BindView(R.id.loginError)
    TextView login_error;

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

        String firstname_val = first_name_input.getText().toString();
        form_values.add(firstname_val);

        String lastname_val = last_name_input.getText().toString();
        form_values.add(lastname_val);

        String email_val = email_input.getText().toString();
        form_values.add(email_val);

        String password_val = password_input.getText().toString();
        form_values.add(password_val);


        if(!checkEmpty(form_values)){
            login_error.setText("Veuillez remplir tous les champs");
            return;
        }

        Log.e("NOT EMPTY", "TRUE");


        UserNetworkManager.registerUsers( firstname_val, lastname_val, email_val, password_val, new UserNetworkManager.UserRegisterResultListener() {

            @Override
            public void onRegisterUsers(User user) {
                Toast.makeText(RegisterActivity.this, "ok", Toast.LENGTH_SHORT).show();

                MyApp.getInstance().setToken(user.getToken());
                login_error.setText("");
                register();
            }

            @Override
            public void onFail() {
                Toast.makeText(RegisterActivity.this, "no", Toast.LENGTH_SHORT).show();
                login_error.setText("Veuillez entrez des information valides");
            }
        });


        //register();
    }



    private boolean checkEmpty(List<String> val){
        for (String res : val) {
            if(res.isEmpty()) return false;
        }
        return true;
    }



    private void onLoginClick(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void register(){
        Intent intent = new Intent(this, AfterRegisterActivity.class);
        startActivity(intent);
    }

}
