package com.l2101600074.eventguideapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountFragment extends Fragment {

    TextView editprof,Mybookings,Myevents,Logout;

    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);

        editprof = rootView.findViewById(R.id.txt_editprofile);
        Mybookings = rootView.findViewById(R.id.txt_mybookings);
        Myevents = rootView.findViewById(R.id.txt_myEvents);
        Logout = rootView.findViewById(R.id.txt_logout);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user==null){
            Intent intent = new Intent(getContext(),Login.class);
            startActivity(intent);
        }

        editprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),EditProfile.class);
                startActivity(intent);
            }
        });
        Mybookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyBooking.class);
                startActivity(intent);
            }
        });
        Myevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MyEvent.class);
                startActivity(intent);
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Do you want to exit the application");
                builder.setCancelable(false);
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(),Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return rootView;
    }
}