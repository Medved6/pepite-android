package com.example.sergewsevolojsky.pepiteapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeEvents implements Parcelable {


    private Integer id;
    private Integer event_id;
    //private String period;
    private Event event;
    private User author;
    private Sport sport;

    public SubscribeEvents(Integer id, Integer event_id, Event event, User author, Sport sport) {
        this.id = id;
        this.event_id = event_id;
        this.event = event;
        this.author = author;
        this.sport = sport;
    }


    public SubscribeEvents(){

    }

    protected SubscribeEvents(Parcel in) {
        event = in.readParcelable(Event.class.getClassLoader());
        author = in.readParcelable(User.class.getClassLoader());
        sport = in.readParcelable(Sport.class.getClassLoader());
    }

    public static final Creator<SubscribeEvents> CREATOR = new Creator<SubscribeEvents>() {
        @Override
        public SubscribeEvents createFromParcel(Parcel in) {
            return new SubscribeEvents(in);
        }

        @Override
        public SubscribeEvents[] newArray(int size) {
            return new SubscribeEvents[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(event, flags);
        dest.writeParcelable(author, flags);
        dest.writeParcelable(sport, flags);
    }
}

