package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProceedPay extends AppCompatActivity {

    ImageButton Backbtn;
    Button save_ok;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_pay);

        Backbtn = findViewById(R.id.arrow_back50);
        save_ok = findViewById(R.id.btnOk);

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });
        save_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Newpage.class);
                startActivity(intent);
            }
        });
    }
}