package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Booking extends AppCompatActivity {

    ImageButton arrowBack;
    Button conirm_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        arrowBack = findViewById(R.id.arrow_back5);
        conirm_pay = findViewById(R.id.btn_confirm);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MakeChoice.class);
                startActivity(intent);
            }
        });
        conirm_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProceedBook.class);
                startActivity(intent);
            }
        });
    }
}