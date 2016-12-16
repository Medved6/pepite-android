package com.example.sergewsevolojsky.pepiteapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.activity.AfterRegisterActivity;
import com.example.sergewsevolojsky.pepiteapp.activity.SportSelectionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoToSportFragment extends Fragment {

    private View rootView;

    @BindView(R.id.go_to_sport)
    Button sport_selection_button;


    public GoToSportFragment() {
        // Required empty public constructor
    }

    public static GoToSportFragment newInstance() {

        Bundle args = new Bundle();

        GoToSportFragment fragment = new GoToSportFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_go_to_sport, container, false);


        ButterKnife.bind(this, rootView);

        sport_selection_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SportSelectionActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



        return rootView;
    }

}
