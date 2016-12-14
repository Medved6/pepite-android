package com.example.sergewsevolojsky.pepiteapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResult {

    private User[] users;

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
