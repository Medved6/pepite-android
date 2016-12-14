package com.example.sergewsevolojsky.pepiteapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.auth0.android.Auth0;
import com.auth0.android.Auth0Exception;
import com.auth0.android.lock.AuthenticationCallback;
import com.auth0.android.lock.Lock;
import com.auth0.android.lock.LockCallback;
import com.auth0.android.lock.utils.LockException;
import com.auth0.android.result.Credentials;
import com.example.sergewsevolojsky.pepiteapp.R;

public class LoginActivity extends AppCompatActivity {

    private Lock lock;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Auth0 auth0 = new Auth0(getString(R.string.auth0_client_id), getString(R.string.auth0_domain));
        lock = Lock.newBuilder(auth0, callback)
                // Add parameters to the Lock Builder
                .build(this);

        startActivity(lock.newIntent(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Your own Activity code
        lock.onDestroy(this);
        lock = null;
    }

    private final LockCallback callback = new AuthenticationCallback() {


        @Override
        public void onAuthentication(Credentials credentials) {
            Toast.makeText(getApplicationContext(), "Log In - Success", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        @Override
        public void onCanceled() {
            Toast.makeText(getApplicationContext(), "Log In - Cancelled", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(LockException error) {
            Toast.makeText(getApplicationContext(), "Log In - Error Occurred", Toast.LENGTH_SHORT).show();
        }
    };
}
