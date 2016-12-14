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

    public Sport(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport() {

    }

    public Sport(Parcel in){
        readFromParcel(in);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    private void readFromParcel(Parcel in) {
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
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
}
