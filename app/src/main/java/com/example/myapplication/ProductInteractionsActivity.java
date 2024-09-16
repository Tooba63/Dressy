package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductInteractionsActivity extends AppCompatActivity {

    private ListView interactionsList;
    private ArrayList<String> interactionsData; // Example data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_interactions);

        // Initialize views
        interactionsList = findViewById(R.id.interactions_list);

        // Mock data (replace with actual data)
        interactionsData = new ArrayList<>();
        interactionsData.add("User1 liked Product 1");
        interactionsData.add("User2 reviewed Product 2");

        // Setup adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, interactionsData);
        interactionsList.setAdapter(adapter);

        // On interaction click
        interactionsList.setOnItemClickListener((parent, view, position, id) -> {
            String selectedInteraction = interactionsData.get(position);
            Toast.makeText(this, "Interaction: " + selectedInteraction, Toast.LENGTH_SHORT).show();
        });
    }
}

