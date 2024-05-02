package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MakeChoice extends AppCompatActivity {

    TextView makePay,MakeBook;
    ImageButton backBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_choice);

        makePay = findViewById(R.id.textView);
        MakeBook = findViewById(R.id.textView1);
        backBtn = findViewById(R.id.arrow_back2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OnselectGrid.class);
                startActivity(intent);
            }
        });

        makePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Payment.class);
                startActivity(intent);
            }
        });

        MakeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Booking.class);
                startActivity(intent);
            }
        });
    }
}