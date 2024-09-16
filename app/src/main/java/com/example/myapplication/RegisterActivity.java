package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput, birthdateInput;
    private Button continueButton, googleButton, signUpButton;
    private TextView loginText, termsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Views
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        birthdateInput = findViewById(R.id.birthdateInput);
        continueButton = findViewById(R.id.continueButton);
        googleButton = findViewById(R.id.googleButton);
        loginText = findViewById(R.id.loginText);
        termsText = findViewById(R.id.termsText);

        // Handle continue button click event
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                String birthdate = birthdateInput.getText().toString();

                // Basic validation
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(birthdate)) {
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with signup logic here
                    Toast.makeText(RegisterActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, UinfoActivity.class);
                    startActivity(intent);}
            }
        });

        // Handle Google button click event
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add Google sign-in logic here
                Toast.makeText(RegisterActivity.this, "Google Sign-In clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle login text click event
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add navigation to login screen
                Toast.makeText(RegisterActivity.this, "Redirect to Login Screen", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle termsText click event
        termsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle opening of Terms and Privacy
                Toast.makeText(RegisterActivity.this, "View Terms of Service", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle the SignUp button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement login process
                Toast.makeText(RegisterActivity.this, "Login button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

