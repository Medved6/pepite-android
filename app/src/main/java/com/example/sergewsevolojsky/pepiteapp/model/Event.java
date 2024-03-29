package com.example.sergewsevolojsky.pepiteapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Parcelable{

    private int author_id;
    private User author;
    private int sport_id;
    private Sport sport;


    private String period;
    private String address;
    private int users_needed;

    public Event(int author_id, User author, int sport_id, Sport sport, String Period, String address, int users_needed) {
        this.author_id = author_id;
        this.author = author;
        this.sport_id = sport_id;
        this.sport = sport;
        this.period = period;
        this.address = address;
        this.users_needed = users_needed;
    }

    public Event() {

    }

    protected Event(Parcel in) {
        author_id = in.readInt();
        author = in.readParcelable(User.class.getClassLoader());
        sport_id = in.readInt();
        sport = in.readParcelable(Sport.class.getClassLoader());
        address = in.readString();
        period = in.readString();
        users_needed = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getSport_id() {
        return sport_id;
    }

    public void setSport_id(int sport_id) {
        this.sport_id = sport_id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAddress() {
        return address;
    }

    public void setAddresse(String addresse) {
        this.address = addresse;
    }

    public int getUsers_needed() {
        return users_needed;
    }

    public void setUsers_needed(int users_needed) {
        this.users_needed = users_needed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(author_id);
        dest.writeParcelable(author, flags);
        dest.writeInt(sport_id);
        dest.writeParcelable(sport, flags);
        dest.writeString(address);
        dest.writeString(period);
        dest.writeInt(users_needed);
    }
}
