package com.example.sergewsevolojsky.pepiteapp.network;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

public class UrlBuilder {

    private final static String BASE_URL = "https://last-player-api.herokuapp.com/api/v1";

    public static String getUserLoginUrl(){
        return String.format("%s/sessions",BASE_URL);
    }

    public static String getUsersUrl(){
        return String.format("%s/users",BASE_URL);
    }

    public static String getUsersById(){
        return String.format("%s/users/1",BASE_URL);
    }


    public static String getSportsUrl() {
        return String.format("%s/sports",BASE_URL);
    }


}
