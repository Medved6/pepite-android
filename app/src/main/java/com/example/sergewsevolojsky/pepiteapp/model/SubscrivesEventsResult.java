package com.example.sergewsevolojsky.pepiteapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscrivesEventsResult {

    private SubscribeEvents[] subscribeEvents;

    public SubscribeEvents[] getSubscribeEvents() {
        return subscribeEvents;
    }

    public void setSubscribeEvents(SubscribeEvents[] subscribeEvents) {
        this.subscribeEvents = subscribeEvents;
    }

}
