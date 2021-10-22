package com.example.mytimelogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayPersonActivity extends AppCompatActivity {
    private TextView displayPersonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_person);

        displayPersonTextView = findViewById(R.id.displayPersonTextView);
        Intent intent = getIntent();
        String personDetails = intent.getStringExtra("myPerson");

        displayPersonTextView.setText(personDetails);
    }
}