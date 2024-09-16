package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UinfoActivity extends AppCompatActivity {

    private EditText usernameInput, heightInput, weightInput, waistInput;
    private Button saveButton;

    // SharedPreferences file name
    private static final String PREFS_NAME = "UserProfile";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uinfo); // Use correct layout file for UinfoActivity

        // Initialize Views
        usernameInput = findViewById(R.id.username_input);
        heightInput = findViewById(R.id.height_input);
        weightInput = findViewById(R.id.weight_input);
        waistInput = findViewById(R.id.waist_input);
        saveButton = findViewById(R.id.save_button);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Save Button onClick Listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }
        });
    }

    // Method to save user profile data
    private void saveUserProfile() {
        String username = usernameInput.getText().toString();
        String height = heightInput.getText().toString();
        String weight = weightInput.getText().toString();
        String waist = waistInput.getText().toString();


        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(height) || TextUtils.isEmpty(weight) || TextUtils.isEmpty(waist)) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("height", height);
        editor.putString("weight", weight);
        editor.putString("waist", waist);
        editor.putString("product1_name", "Favorite Dress 1");
        editor.putString("product2_name", "Favorite Dress 2");
        editor.apply();

        Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show();

        // Move to ProfileActivity to display saved details
        Intent intent = new Intent(UinfoActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish(); // Finish current activity
    }
}
