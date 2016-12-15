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




    // USER LOGIN


    // LISTENER
    public interface UserLoginResultListener {
        void onLoginUsers(User users);

        void onFail();
    }


    //METHOD
    public static void loginUsers(String email, String password, final UserLoginResultListener listener) {


        Map<String,String> params = new HashMap<String, String>();
        params.put("Content-Type","application/form-data");
        params.put("email",email);
        params.put("password",password);


        String url = UrlBuilder.getUserLoginUrl();
        JacksonRequest<User> request = new JacksonRequest<>(Request.Method.POST, url, params, new JacksonRequestListener<User>() {
            @Override
            public void onResponse(User response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null)
                            listener.onLoginUsers(response);
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(User.class);
            }

        });

        MyApp.getInstance().getRequestQueue().add(request);
    }






    // USER LOGIN


    // LISTENER
    public interface UserRegisterResultListener {
        void onRegisterUsers(User users);

        void onFail();
    }


    //METHOD
    public static void registerUsers(String firstname, String lastname, String email, String password, final UserRegisterResultListener listener) {


        Map<String,String> params = new HashMap<String, String>();
        params.put("Content-Type","application/form-data");
        params.put("email",firstname);
        params.put("password",lastname);
        params.put("email",email);
        params.put("password",password);


        String url = UrlBuilder.getUserRegistersUrl();
        JacksonRequest<User> request = new JacksonRequest<>(Request.Method.POST, url, params, new JacksonRequestListener<User>() {
            @Override
            public void onResponse(User response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null)
                            listener.onRegisterUsers(response);
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(User.class);
            }

        });

        MyApp.getInstance().getRequestQueue().add(request);
    }








}











