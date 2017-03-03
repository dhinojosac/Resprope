package com.dhinojosac.android.resprope.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.dhinojosac.android.resprope.R;
import com.dhinojosac.android.resprope.adapters.IncidentAdapterRecyclerView;
import com.dhinojosac.android.resprope.model.Incidencium;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        showToolbar("Incidentes",false, view);
        RecyclerView incidentRecyclerView = (RecyclerView) view.findViewById(R.id.incidentRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        incidentRecyclerView.setLayoutManager(linearLayoutManager);
        IncidentAdapterRecyclerView adapterRecyclerView = new IncidentAdapterRecyclerView(getIncidentList(),R.layout.cardview_incident, getActivity());

        incidentRecyclerView.setAdapter(adapterRecyclerView);

        return view;
    }

    public ArrayList<Incidencium> getIncidentList(){
        ArrayList<Incidencium> incidentList = new ArrayList<>();
        incidentList.add(new Incidencium("Choque grave","1"));
        incidentList.add(new Incidencium("Trabajo en ruta", "2"));
        incidentList.add(new Incidencium("Trafico denso", "3"));
        incidentList.add(new Incidencium("Desvio en la ruta", "4"));
        incidentList.add(new Incidencium("Camino inundado", "4"));
        incidentList.add(new Incidencium("ACcidente en ruta", "4"));

        return  incidentList;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
