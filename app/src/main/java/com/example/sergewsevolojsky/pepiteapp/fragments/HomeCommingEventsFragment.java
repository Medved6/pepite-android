package com.example.sergewsevolojsky.pepiteapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergewsevolojsky.pepiteapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeCommingEventsFragment extends Fragment {


    public HomeCommingEventsFragment() {
        // Required empty public constructor
    }

    public static HomeCommingEventsFragment newInstance() {

        Bundle args = new Bundle();

        HomeCommingEventsFragment fragment = new HomeCommingEventsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_comming_events, container, false);
    }







}
