package com.example.mytimelogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayPersonActivity extends AppCompatActivity {
    private TextView displayPersonTextView;
    private ArrayList<Person>personArrayList;
    private int currentPersonIndex; //To navigate the array Index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_person);

        displayPersonTextView = findViewById(R.id.displayPersonTextView);
        Intent intent = getIntent();
        personArrayList = (ArrayList<Person>) intent.getSerializableExtra("allPersons");

        String message = "";
        currentPersonIndex = -1;
        if (personArrayList.size()!=0) {
            message = personArrayList.get(0).getMessage(); //getting first Person
            currentPersonIndex = 0; //helps indicate if there are cars in the arraylist
        }


        displayPersonTextView.setText(message +  "\nNumber of logged times: " + personArrayList.size()); // how many people have logged time
    }

    public void onNextPersonButtonClick(View view) {

        if (currentPersonIndex != -1) {
            currentPersonIndex++; //go to next car
            currentPersonIndex = currentPersonIndex%personArrayList.size();

            Person person = personArrayList.get(currentPersonIndex);

            displayPersonTextView.setText(person.getMessage());
        }
    }
}