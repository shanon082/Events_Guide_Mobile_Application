package com.l2101600074.eventguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditFragment extends Fragment {

    View rootView;
    Spinner selectEventSpinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_edit, container, false);
        selectEventSpinner = rootView.findViewById(R.id.editEvent_category);

// Define the array of options
        String[] eventOptions = {"sports", "festivals", "concerts", "meetings", "party", "conferences", "other"};

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, eventOptions);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        selectEventSpinner.setAdapter(adapter);


        return rootView;
    }
}