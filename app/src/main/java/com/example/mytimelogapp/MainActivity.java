package com.example.mytimelogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText NameEditText;  //link to xml EditText in onCreate()
    private EditText TimeEditText;
    private EditText DateEditText;
    private EditText TimeOutEditText;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEditText = findViewById(R.id.NameEditText); // Linked all four to xmL's EditText to get info
        TimeEditText = findViewById(R.id.TimeEditText);
        DateEditText = findViewById(R.id.DateEditText);
        TimeOutEditText = findViewById(R.id.TimeOutEditText);
    }

    public void onLogTimeButtonClick(View view) {
        //Capture the info from NameEditText, TimeEditText, YearEditText and TimeOutEditText
        String personName = NameEditText.getText().toString();
        String personTime = TimeEditText.getText().toString();
        String personDate = DateEditText.getText().toString();
        String personTimeOut = TimeOutEditText.getText().toString();

        //Create Person object from the information above
        String message;
        if (!personName.trim().equals("")){ //if name is not empty, object will be created
            //convert str to number
            int time;
            try {
                time = Integer.parseInt(personTime);
            } catch (NumberFormatException nfe) {
                time = 830; // default to 830 if cannot be converted
            }

            int date;
            try {
                date = Integer.parseInt(personDate);
            } catch (NumberFormatException nfe) {
                date = 010121; //default to 010121 if cannot be converted
            }

            int timeout;
            try {
                timeout = Integer.parseInt(personTimeOut);
            } catch (NumberFormatException nfe) {
                timeout = 1830; //default to 1830 if cannot be converted
            }

            person = new Person(personName, time, date, timeout);
            message = person.getMessage();
        } else {
            message = "Please enter a valid Name, Time, Date and Timeout";
        }

        //Displays the persons info using a Toast
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void onViewPersonButtonClick(View view) {
        Intent intent = new Intent(this, DisplayPersonActivity.class);
        if (person != null) {
            intent.putExtra("myPerson", person.getMessage());
        } else {
            intent.putExtra("myPerson", "No one has logged time!");
        }
        startActivity(intent);
    }
}