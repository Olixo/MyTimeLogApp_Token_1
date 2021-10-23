package com.example.mytimelogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DisplayPersonActivity extends AppCompatActivity {
    private TextView displayPersonTextView;
    private ArrayList<Person>personArrayList;
    private int currentPersonIndex; //To navigate the array Index


    private  static final String TAG = "DisplayPersonActivity";

    //File Details
    private static final String FILE_NAME= "all_Logs.txt"; // <-- Name of file
    private File file; // File object to perform task
    private FileOutputStream outputStream;
    private FileInputStream inputStream;

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

        file = new File(this.getFilesDir(), FILE_NAME); // creating a file object
    }

    public void onNextPersonButtonClick(View view) {

        if (currentPersonIndex != -1) {
            currentPersonIndex++; //go to next car
            currentPersonIndex = currentPersonIndex%personArrayList.size();

            Person person = personArrayList.get(currentPersonIndex);

            displayPersonTextView.setText(person.getMessage());
        }
    }

    public void onSaveButtonClick(View view) {
        if (personArrayList.size()>0) {
            try {
                outputStream = new FileOutputStream(file);
                //creating a stream to connect to file object
                int numPeople = personArrayList.size();
                String data = "Number of people: " + numPeople;
                //prepare the information to write

                outputStream.write(data.getBytes());
                //convert to bytes and write to outputstream
                Log.d(TAG, "SAVING SUCCESS!!");
                outputStream.close();

            } catch (Exception e) {
                Log.d(TAG, "WRITING FILE UNSUCCSESSFUL!!");
                e.printStackTrace();
            }
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "No data to save", Toast.LENGTH_SHORT).show();
        }
    }

    public void onLoadLogButtonClick(View view) {
        // create byte array to hold information based on length
        int length = (int) file.length();
        byte[] bytes = new byte[length];

        try {
            //create fileinputstream object to read from file
            inputStream = new FileInputStream(file);

            //read into array
            inputStream.read(bytes);
            inputStream.close();

            String data = new String(bytes); //converting bytes into string

            Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d(TAG, "L");
            e.printStackTrace();
        }

    }
}