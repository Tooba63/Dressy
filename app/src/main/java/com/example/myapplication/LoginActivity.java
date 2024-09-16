package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {



    private EditText email, password;
    private Button loginButton, facebookButton, googleButton, signUpButton;
    private TextView forgotPassword, termsText, signUpText;
    private ImageView googleImage, facebookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        facebookButton = findViewById(R.id.facebook_button);
        googleButton = findViewById(R.id.google_button);
        forgotPassword = findViewById(R.id.forgot_password);
        termsText = findViewById(R.id.terms);
        signUpText = findViewById(R.id.sign_up);


        // Handle login button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();

                // Validate email and password
                if (TextUtils.isEmpty(emailInput) || TextUtils.isEmpty(passwordInput)) {
                    Toast.makeText(LoginActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Implement login logic here (e.g., authentication API call)

                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Handle forgot password click
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement forgot password logic
                Toast.makeText(LoginActivity.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Facebook login button click
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Facebook login logic here
                Toast.makeText(LoginActivity.this, "Facebook login clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Google login button click
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google login logic here
                Toast.makeText(LoginActivity.this, "Google login clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle sign-up text click
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement sign-up screen redirection
                Toast.makeText(LoginActivity.this, "Redirect to sign-up screen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });



        // Terms of Service click
        termsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle displaying terms of service and privacy policy
                Toast.makeText(LoginActivity.this, "View Terms of Service", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

