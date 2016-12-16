package com.example.sergewsevolojsky.pepiteapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResult {

    private Event[] events;

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }
}