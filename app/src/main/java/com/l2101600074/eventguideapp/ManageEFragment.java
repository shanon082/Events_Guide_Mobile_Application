package com.l2101600074.eventguideapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ManageEFragment extends Fragment {

    TextView attend,stat,discuss;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       /* btn_attendees = (ImageButton) btn_attendees.findViewById(R.id.attend);
        btn_discussion = (ImageButton) btn_discussion.findViewById(R.id.btn_disc);
        btn_statistics = (ImageButton) btn_statistics.findViewById(R.id.btn_stat);

        btn_attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Attendees.class);
                startActivity(intent);
            }
        });
        btn_discussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Discussion.class);
                startActivity(intent);
            }
        });
        btn_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Statistics.class);
                startActivity(intent);
            }
        });*/
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_manage_e, container, false);

        attend = rootview.findViewById(R.id.attend);
        stat = rootview.findViewById(R.id.stat);
        discuss = rootview.findViewById(R.id.disc);

        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Attendees.class);
                startActivity(intent);
            }
        });
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Statistics.class);
                startActivity(intent);
            }
        });
        discuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Discussion.class);
                startActivity(intent);
            }
        });

        return rootview;
    }


}