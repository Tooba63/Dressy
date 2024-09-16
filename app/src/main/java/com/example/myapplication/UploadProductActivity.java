package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadProductActivity extends AppCompatActivity {

    private ImageView productImage;
    private EditText productName, productPrice, productDescription, productStock;
    private Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_product);

        // Initialize views
        productImage = findViewById(R.id.product_image);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);
        productStock = findViewById(R.id.product_stock);
        uploadButton = findViewById(R.id.upload_button);

        // Click listener for image upload (mocked)
        productImage.setOnClickListener(v -> {
            // TODO: Add image upload logic
        });

        // Click listener for the upload button
        uploadButton.setOnClickListener(v -> {
            String name = productName.getText().toString();
            String price = productPrice.getText().toString();
            String description = productDescription.getText().toString();
            String stock = productStock.getText().toString();

            if (name.isEmpty() || price.isEmpty() || description.isEmpty() || stock.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Upload product logic here
                Toast.makeText(this, "Product Uploaded!", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity after uploading
            }
        });
    }
}

