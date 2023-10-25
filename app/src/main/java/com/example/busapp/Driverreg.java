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

public class Driverreg extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText driverUsernameEditText, driverEmailEditText, driverPasswordEditText, driverRepasswordEditText;
    private Button driverSignupButton, driverLoginNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverreg);
        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

        driverUsernameEditText = findViewById(R.id.dusername);
        driverEmailEditText = findViewById(R.id.demail);
        driverPasswordEditText = findViewById(R.id.dpassword);
        driverRepasswordEditText = findViewById(R.id.drepassword);

        driverSignupButton = findViewById(R.id.dsigup);
        driverLoginNextButton = findViewById(R.id.logint);

        driverLoginNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login activity or page
                Intent intent = new Intent(Driverreg.this, Driverlog.class);
                startActivity(intent);
            }
        });

        driverSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDriver();
            }
        });
    }

    private void registerDriver() {
        String username = driverUsernameEditText.getText().toString();
        String email = driverEmailEditText.getText().toString();
        String password = driverPasswordEditText.getText().toString();
        String repassword = driverRepasswordEditText.getText().toString();

        if (password.equals(repassword)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Registration successful
                                Toast.makeText(Driverreg.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            } else {
                                // Registration failed
                                Toast.makeText(Driverreg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            // Passwords do not match
            Toast.makeText(Driverreg.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }
}
