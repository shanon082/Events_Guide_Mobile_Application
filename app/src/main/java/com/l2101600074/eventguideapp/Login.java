package com.l2101600074.eventguideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class Login extends AppCompatActivity {

    EditText Email,Password;
    Button btn_Login;
    TextView forgtPass, Clicknew;
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
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.editEmail);
        Password = findViewById(R.id.editPassword);
        btn_Login = findViewById(R.id.btn_login);
        forgtPass = findViewById(R.id.txt_fgtpasswd);
        Clicknew = findViewById(R.id.txt_clicknew);
        progressBar = findViewById(R.id.progressbar);


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;
                email = String.valueOf(Email.getText());
                password = String.valueOf(Password.getText());
                progressBar.setVisibility(View.VISIBLE);
                Email.setError(null);

                if (TextUtils.isEmpty(email)){
                    Email.setError("Email is required");
                    Email.requestFocus();
                    }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("Valid Email is required");
                    Email.requestFocus();
                    Toast.makeText(getApplicationContext(), "Enter valid email", Toast.LENGTH_SHORT).show();
                }
                    if (TextUtils.isEmpty(password)){
                    Password.setError("Password is required");
                    Password.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this, "Login successful",
                                            Toast.LENGTH_SHORT).show();
                                    sendNotification();
                                    Intent intent = new Intent(getApplicationContext(), HomePage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login.this, "Authentication failed, please review your details or create an account",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        forgtPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SetPass.class);
                startActivity(intent);
            }
        });

        Clicknew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, NewUser.class);
                startActivity(intent);
            }
        });
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(R.drawable.baseline_notifications_active_24)
                .setContentTitle("Events Guide Info")
                .setContentText("We have been missing you. Explore your favorite event!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1, builder.build());
    }
}