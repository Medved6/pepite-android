package com.example.sergewsevolojsky.pepiteapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.activity.MainActivity;
import com.example.sergewsevolojsky.pepiteapp.adapter.SportsAdpater;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;
import com.example.sergewsevolojsky.pepiteapp.network.SportNetworkManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergewsevolojsky on 13/12/2016.
 */

public class SportSelectionFragment extends Fragment {

    private View rootView;
    private ListView listView;
    private List<Sport> allSports;
    private SportsAdpater sportAdapter;
    final Hashtable selectedSports = new Hashtable();
    List<Integer> sport_ids = new ArrayList<Integer>();



    @BindView(R.id.sport_edit_text)
    EditText searchBar;

    @BindView(R.id.validateSelection)
    Button validateSelection;

    @BindView(R.id.skipSelection)
    Button skipSelection;

    public static SportSelectionFragment newInstance() {

        Bundle args = new Bundle();

        SportSelectionFragment fragment = new SportSelectionFragment();
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sports_selection, container, false);

        ButterKnife.bind(this, rootView);


        sportAdapter = new SportsAdpater(getContext());

        listView = (ListView) rootView.findViewById(R.id.sport_list);
        listView.setDivider(null);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                CheckBox checkBox = (CheckBox) view.findViewById(R.id.list_check);

                if( !checkBox.isChecked() )
                    checkBox.setChecked(true);
                else
                    checkBox.setChecked(false);


                if(!sport_ids.contains(allSports.get(i).getId())){
                    sport_ids.add(allSports.get(i).getId());
                } else {
                    sport_ids.remove(allSports.get(i).getId());
                }
            }
        });


        listView.setAdapter(sportAdapter);


        SportNetworkManager.getSports(new SportNetworkManager.SportsResultListener()  {
            @Override
            public void onFindSport(ArrayList<Sport> sports) {
                Log.e("RESERVATIONS",sports.toString());

                allSports = sports;

                if(!sports.isEmpty()){

                    sportAdapter.refresh(sports);
                } else {
                    Log.i("RESERVATION", "EMPTY");
                }
            }

            @Override
            public void onFail() {}
        });




        return rootView;

    }



    @Override
    public void onStart() {
        super.onStart();
        bindEvents();
    }



    // BIND ALL FRAGMENT EVENTS
    public void bindEvents(){
        onSearchKeyup();
        onValidateClick();
        onSkipClick();
    }





    public void onValidateClick(){

        validateSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("VALIDATE", selectedSports.getClass().toString());

                selectedSports.put("sport_ids", sport_ids);

                String jsonString = new Gson().toJson(selectedSports);



                Log.e("VALIDATE 2", jsonString);

                //goHome();


            }
        });

    }




    public void onSkipClick(){
        skipSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });
    }








    // SEARCH FUNCTION
    public void onSearchKeyup() {


        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("LOGER", s + ""); // show the count of the Text in the TextView

                List<Sport> newResult = new ArrayList<>();

                for (int i = 0; i < allSports.size(); i++) {


                    String val = allSports.get(i).getName().toLowerCase();

                    Log.e("sport", val.substring(0,s.length()) );
                    Log.e("search", s.toString().toLowerCase() );

                    if(val.contains(s.toString().toLowerCase())) {
                        newResult.add(allSports.get(i));
                    }

                }

                if(s.length() == 0) {
                    Log.d("empyu","true");
                    sportAdapter.refresh((ArrayList<Sport>) allSports);
                } else {
                    sportAdapter.refresh((ArrayList<Sport>) newResult);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }




    public void goHome(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

}
