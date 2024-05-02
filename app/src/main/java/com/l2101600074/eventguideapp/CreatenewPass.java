package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatenewPass extends AppCompatActivity {

    EditText newEmail,newName;
    Button btn_savePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnew_pass);

        btn_savePass = findViewById(R.id.btn_save);
        //newEmail = findViewById(R.id.NewEmail);
        //newName = findViewById(R.id.NewPassword);

        btn_savePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}