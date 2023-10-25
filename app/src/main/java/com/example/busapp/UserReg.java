package com.example.busapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserReg extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText usernameEditText, emailEditText, passwordEditText, repasswordEditText;
    private Button signupButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        FirebaseApp.initializeApp(this);


        mAuth = FirebaseAuth.getInstance();

        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        repasswordEditText = findViewById(R.id.repassword);

        signupButton = findViewById(R.id.sigup);
        loginButton = findViewById(R.id.loginnxt);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement login functionality or navigate to the login activity.
                Intent intent = new Intent(UserReg.this, Userlog.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String repassword = repasswordEditText.getText().toString();

        if (password.equals(repassword)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Registration successful
                                Toast.makeText(UserReg.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            } else {
                                // Registration failed
                                Toast.makeText(UserReg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            // Passwords do not match
            Toast.makeText(UserReg.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }
}

