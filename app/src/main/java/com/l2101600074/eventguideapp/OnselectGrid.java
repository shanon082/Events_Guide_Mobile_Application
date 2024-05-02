package com.l2101600074.eventguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OnselectGrid extends AppCompatActivity {

    ImageButton arrow_exit4;

    Button bookandPay_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onselect_grid);

        arrow_exit4 = findViewById(R.id.arrow_exit4);
        bookandPay_btn = findViewById(R.id.btn_bookandpay);

        bookandPay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MakeChoice.class);
                startActivity(intent);
            }
        });

        arrow_exit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}