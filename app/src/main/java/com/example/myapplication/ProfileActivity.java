package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameTextView, heightTextView, weightTextView, waistTextView;
    private TextView productName1TextView, productName2TextView;
    private ImageView productImage1, productImage2;
    private Button logoutButton;

    // SharedPreferences file name
    private static final String PREFS_NAME = "UserProfile";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Using the XML file you provided

        // Initialize Views
        usernameTextView = findViewById(R.id.username);
        heightTextView = findViewById(R.id.height);
        weightTextView = findViewById(R.id.weight);
        waistTextView = findViewById(R.id.waist);
        productName1TextView = findViewById(R.id.product_name_1);
        productName2TextView = findViewById(R.id.product_name_2);
        productImage1 = findViewById(R.id.product_image_1);
        productImage2 = findViewById(R.id.product_image_2);
        logoutButton = findViewById(R.id.logout_button);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Load and display user profile data
        loadUserProfile();

        // Logout Button Listener
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });
    }

    // Method to load user profile data and display
    private void loadUserProfile() {
        String username = sharedPreferences.getString("username", "N/A");
        String height = sharedPreferences.getString("height", "N/A");
        String weight = sharedPreferences.getString("weight", "N/A");
        String waist = sharedPreferences.getString("waist", "N/A");

        // Wishlist products (for demo purposes)
        String product1Name = sharedPreferences.getString("product1_name", "Product 1");
        String product2Name = sharedPreferences.getString("product2_name", "Product 2");

        // Set the data to the respective views
        usernameTextView.setText(username);
        heightTextView.setText(height + " cm");
        weightTextView.setText(weight + " kg");
        waistTextView.setText(waist + " inches");

        // Set wishlist data
        productName1TextView.setText(product1Name);
        productName2TextView.setText(product2Name);

        // For demo purposes, use a placeholder image. You can use a URL to load actual images using a library like Glide or Picasso.
        productImage1.setImageResource(R.drawable.product_placeholder);
        productImage2.setImageResource(R.drawable.product_placeholder);
    }

    // Method to log out the user and return to the login screen
    private void logOut() {
        // Clear SharedPreferences (if you want to remove saved user data on logout)
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Redirect to LoginActivity (or any other appropriate activity)
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Close the profile activity
    }
}
