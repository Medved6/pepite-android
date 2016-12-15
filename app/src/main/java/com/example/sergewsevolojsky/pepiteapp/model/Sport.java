package com.example.sergewsevolojsky.pepiteapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sport implements Parcelable {

    private String name;
    private Integer id;

    public Sport(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Sport(){

    }

    protected Sport(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
