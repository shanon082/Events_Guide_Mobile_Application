package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {
    ImageButton exit_page;
    Button btn_saveprofile;

    EditText editName, editEmail, editBio;
    ImageView imageView;
    Uri imageUri; // Store the URI of the selected image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        exit_page = findViewById(R.id.arrow_exitedit);
        editName = findViewById(R.id.edit_Nameprof);
        editEmail = findViewById(R.id.edit_Emailprof);
        editBio = findViewById(R.id.edit_Bioprof);
        btn_saveprofile = findViewById(R.id.Save_prof);



        exit_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_saveprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();
            }
        });
    }
}