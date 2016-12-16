package com.example.sergewsevolojsky.pepiteapp.network;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.pepiteapp.MyApp;
import com.example.sergewsevolojsky.pepiteapp.model.Event;
import com.example.sergewsevolojsky.pepiteapp.model.EventResult;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;
import com.example.sergewsevolojsky.pepiteapp.model.SportResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sergewsevolojsky on 16/12/2016.
 */

public class EventsNetwworkManager {

    // LISTENER
    public interface EventsResultListener {
        void onFindEvents(ArrayList<Event> events);

        void onFail();
    }



    // REQUEST
    public static void getEvent(final EventsNetwworkManager.EventsResultListener listener) {

        String url = UrlBuilder.getEventsUrl();

        JacksonRequest<EventResult> request = new JacksonRequest<>(Request.Method.GET, url, new JacksonRequestListener<EventResult>() {
            @Override
            public void onResponse(EventResult response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindEvents(new ArrayList<>(Arrays.asList(response.getEvents())));
                        }
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(EventResult.class);
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MyApp.getInstance().getRequestQueue().add(request);
    }


}
