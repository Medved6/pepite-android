package com.example.sergewsevolojsky.pepiteapp.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.pepiteapp.MyApp;
import com.example.sergewsevolojsky.pepiteapp.model.SportResult;
import com.example.sergewsevolojsky.pepiteapp.model.User;
import com.example.sergewsevolojsky.pepiteapp.model.UserResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

public class UserNetworkManager {




    // USER REGISTER


    // LISTENER
    public interface UserLoginResultListener {
        void onRegisterUsers(User[] users);

        void onFail();
    }


    //METHOD
    public static void registerUsers(String email, String password, final UserLoginResultListener listener) {


        Map<String,String> params = new HashMap<String, String>();
        params.put("Content-Type","application/form-data");
        params.put("email",email);
        params.put("password",password);


        String url = UrlBuilder.getUserLoginUrl();
        JacksonRequest<UserResult> request = new JacksonRequest<>(Request.Method.POST, url, params, new JacksonRequestListener<UserResult>() {
            @Override
            public void onResponse(UserResult response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null)
                            listener.onRegisterUsers(response.getUsers());
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(UserResult.class);
            }

        });

        MyApp.getInstance().getRequestQueue().add(request);
    }








}











