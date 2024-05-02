package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Payment extends AppCompatActivity {

    Button btn_confirmPay;
    ImageButton arrowBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn_confirmPay = findViewById(R.id.btnconfirm);
        arrowBack = findViewById(R.id.arrow_back5);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MakeChoice.class);
                startActivity(intent);
            }
        });

        btn_confirmPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProceedPay.class);
                startActivity(intent);
            }
        });
    }
}