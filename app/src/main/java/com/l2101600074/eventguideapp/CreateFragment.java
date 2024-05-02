package com.l2101600074.eventguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CreateFragment extends Fragment {
    View rootView;
    Spinner selectEventSpinner;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    StorageReference mstoreRef;
    Event event;
    int image_request_code = 7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create, container, false);

        selectEventSpinner = rootView.findViewById(R.id.select_catgory);
        String[] eventOptions = {"sports", "festivals", "concerts", "meetings", "party", "conferences", "other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, eventOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectEventSpinner.setAdapter(adapter);



        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Event");
        mstoreRef = FirebaseStorage.getInstance().getReference();
        event = new Event();

        Button upload = rootView.findViewById(R.id.btn_browser);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), image_request_code);
            }
        });

        Button createEventButton = rootView.findViewById(R.id.btn_createEvent);
        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEventDataToFirebase();
            }
        });

        return rootView;
    }

    private void saveEventDataToFirebase() {
        EditText titleEditText = rootView.findViewById(R.id.Event_title);
        EditText venueEditText = rootView.findViewById(R.id.Event_venue);
        EditText feeEditText = rootView.findViewById(R.id.Event_fee);
        EditText descriptionEditText = rootView.findViewById(R.id.Event_description);
        EditText emailEditText = rootView.findViewById(R.id.Event_email);
        EditText phoneEditText = rootView.findViewById(R.id.Event_phnumber);

        String title = titleEditText.getText().toString();
        String venue = venueEditText.getText().toString();
        String fee = feeEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String category = selectEventSpinner.getSelectedItem().toString();


        if (TextUtils.isEmpty(title)&&TextUtils.isEmpty(venue)&&TextUtils.isEmpty(fee)&&TextUtils.isEmpty(description)&&TextUtils.isEmpty(email)&&TextUtils.isEmpty(phone)&&TextUtils.isEmpty(category)){
            Toast.makeText(getContext(),"Please add information",Toast.LENGTH_SHORT).show();
        }
        else {
            addDataToFB(title,venue,fee,description,email,phone,category);
        }

//        String eventId = databaseReference.push().getKey();
//        if (eventId != null) {
//            databaseReference.child(eventId).setValue(event);
//        }
    }

    private void addDataToFB(String title, String venue, String fee, String description, String email, String phone, String category) {
        event.setTitle(title);
        event.setTitle(venue);
        event.setTitle(fee);
        event.setTitle(description);
        event.setTitle(email);
        event.setTitle(phone);
        event.setTitle(category);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(event);
                Toast.makeText(getContext(),"Event successfull added",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"Failed to add Event",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
