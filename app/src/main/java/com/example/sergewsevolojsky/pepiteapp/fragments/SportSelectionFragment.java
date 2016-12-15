package com.example.sergewsevolojsky.pepiteapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sergewsevolojsky.pepiteapp.MyApp;
import com.example.sergewsevolojsky.pepiteapp.R;
import com.example.sergewsevolojsky.pepiteapp.adapter.SportsAdpater;
import com.example.sergewsevolojsky.pepiteapp.model.Sport;
import com.example.sergewsevolojsky.pepiteapp.network.SportNetworkManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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


    @BindView(R.id.sport_edit_text)
    EditText searchBar;

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


        final Hashtable test = new Hashtable();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("CLICK", "Position=" + i);

                if(!test.contains(i)){
                    test.put(i, allSports.get(i).getName().toString());
                } else {
                    test.remove(i);
                }

                Log.e("Test", test.toString());


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

        bindSearch();
    }









    public void bindSearch() {


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

                    if(val.contains(s)) {
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


}
