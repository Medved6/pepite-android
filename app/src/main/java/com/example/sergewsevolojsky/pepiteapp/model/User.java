package com.example.sergewsevolojsky.pepiteapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Parcelable{

    private String firstname;
    private String lastname;
    private int id;
    private String email;
    private String bio;
    private String token;
    private SubscrivesEventsResult event_subscriptions;

    public User(String firstname, String lastname, int id, String email, String bio, String token, SubscrivesEventsResult event_subscriptions) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.email = email;
        this.bio = bio;
        this.token = token;
        this.event_subscriptions = event_subscriptions;
    }

    public User(){

    }

    protected User(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        id = in.readInt();
        email = in.readString();
        bio = in.readString();
        token = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SubscrivesEventsResult getEvent_subscriptions() {
        return event_subscriptions;
    }

    public void setEvent_subscriptions(SubscrivesEventsResult event_subscriptions) {
        this.event_subscriptions = event_subscriptions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeInt(id);
        dest.writeString(email);
        dest.writeString(bio);
        dest.writeString(token);
    }
}
