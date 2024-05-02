package com.l2101600074.eventguideapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewUser extends AppCompatActivity {

    EditText newName,newPass,newEmail,confirmPass;
    TextView txtNameError, txtEmailError, txtPassError, txtConfirmPassError;

    Button btn_signup;
    TextView txt_login;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        mAuth = FirebaseAuth.getInstance();

        btn_signup = findViewById(R.id.btn_Signup);
        txt_login = findViewById(R.id.txt_clicklogin);
        newEmail=findViewById(R.id.edit_newUserEmail);
        newName = findViewById(R.id.edit_newName);
        confirmPass = findViewById(R.id.edit_confirmPassword);
        newPass = findViewById(R.id.edit_newUserPassword);
        progressBar = findViewById(R.id.progressbar);

        txtNameError = findViewById(R.id.txt_name_error);
        txtEmailError = findViewById(R.id.txt_email_error);
        txtPassError = findViewById(R.id.txt_password_error);
        txtConfirmPassError = findViewById(R.id.txt_confirm_password_error);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newName.getText().toString().trim();
                String passwordt = newPass.getText().toString().trim();
                String email,password;
                email = newEmail.getText().toString();
                password = confirmPass.getText().toString();
                progressBar.setVisibility(View.VISIBLE);

                txtNameError.setVisibility(View.GONE);
                txtEmailError.setVisibility(View.GONE);
                txtPassError.setVisibility(View.GONE);
                txtConfirmPassError.setVisibility(View.GONE);

                if (TextUtils.isEmpty(name)){
                    txtNameError.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Enter name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    txtEmailError.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passwordt)){
                    txtPassError.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passwordt.length() < 6) {
                    txtPassError.setText("Password must be at least 6 characters long");
                    txtPassError.setVisibility(View.VISIBLE);
                    return;
                }

                if (!passwordt.equals(password)) {
                    txtConfirmPassError.setText("Passwords do not match");
                    txtConfirmPassError.setVisibility(View.VISIBLE);
                    return;
                }

//                if (TextUtils.isEmpty(password)){
//                    txtConfirmPassError.setVisibility(View.VISIBLE);
//                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
//                    return;
//                }


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(NewUser.this, "Registration successfull.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),ConfirmScreen1.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                     Toast.makeText(NewUser.this, "Registration failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}