package com.example.sergewsevolojsky.pepiteapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 14/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SportResult {

    private Sport[] sports;

    public Sport[] getSports() {
        return sports;
    }

    public void setSports(Sport[] sports) {
        this.sports = sports;
    }
}
