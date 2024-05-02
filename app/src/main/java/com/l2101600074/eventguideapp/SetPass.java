package com.l2101600074.eventguideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;

public class SetPass extends AppCompatActivity {
    FirebaseAuth mAuth;
    ImageButton arrowback;

    EditText newEmail;
    Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pass);
        mAuth = FirebaseAuth.getInstance();
        arrowback = findViewById(R.id.arrow_back);
        newEmail = findViewById(R.id.edit_newEmail);
        btn_finish = findViewById(R.id.btn_finish);

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = newEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    newEmail.setError("Email is required");
                    newEmail.requestFocus();
                    Toast.makeText(getApplicationContext(),"Enter your registered email",Toast.LENGTH_SHORT).show();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    newEmail.setError("Valid Email is required");
                    newEmail.requestFocus();
                    Toast.makeText(getApplicationContext(),"Enter valid email",Toast.LENGTH_SHORT).show();

                }
                else {
                    resetPassword(email);
                }
            }
        });
    }

    private void resetPassword(String email) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Check your email",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"An error occured,",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}