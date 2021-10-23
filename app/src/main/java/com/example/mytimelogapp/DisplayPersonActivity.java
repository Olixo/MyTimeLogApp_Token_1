package com.example.mytimelogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayPersonActivity extends AppCompatActivity {
    private TextView displayPersonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_person);

        displayPersonTextView = findViewById(R.id.displayPersonTextView);
        Intent intent = getIntent();
        ArrayList<Person> personArrayList = (ArrayList<Person>) intent.getSerializableExtra("allPersons");

        displayPersonTextView.setText("Number of logged times: " + personArrayList.size()); // how many people have logged time
    }
}