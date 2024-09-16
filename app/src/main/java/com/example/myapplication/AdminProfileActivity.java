package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class AdminProfileActivity extends AppCompatActivity {

    private ImageButton chatIcon, uploadIcon, viewProductsIcon, productInteractionsIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        // Initialize icons
        chatIcon = findViewById(R.id.chat_icon);
        uploadIcon = findViewById(R.id.upload_icon);
        viewProductsIcon = findViewById(R.id.view_products_icon);
        productInteractionsIcon = findViewById(R.id.product_interactions_icon);

        // Chat button logic
        chatIcon.setOnClickListener(v -> openChatPage());

        // Upload button logic
        uploadIcon.setOnClickListener(v -> openUploadProductPage());

        // View Products button logic
        viewProductsIcon.setOnClickListener(v -> openViewProductsPage());

        // Product Interactions button logic
        productInteractionsIcon.setOnClickListener(v -> openProductInteractionsPage());
    }

    // Open Chat Page
    private void openChatPage() {
        Intent intent = new Intent(AdminProfileActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    // Open Upload Product Page
    private void openUploadProductPage() {
        Intent intent = new Intent(AdminProfileActivity.this, UploadProductActivity.class);
        startActivity(intent);
    }

    // Open View Products Page
    private void openViewProductsPage() {
        Intent intent = new Intent(AdminProfileActivity.this, ViewProductsActivity.class);
        startActivity(intent);
    }

    // Open Product Interactions Page
    private void openProductInteractionsPage() {
        Intent intent = new Intent(AdminProfileActivity.this, ProductInteractionsActivity.class);
        startActivity(intent);
    }
}
