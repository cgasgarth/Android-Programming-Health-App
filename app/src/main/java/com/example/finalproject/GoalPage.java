package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class GoalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page2);
        //setting physical goals
        EditText setPhyGoal = findViewById(R.id.setPhyGoal);
        CheckBox phyDaily = findViewById(R.id.phyCheckBox);
        CheckBox phyWeekly = findViewById(R.id.phyCheckBox2);
        CheckBox phyMonthly = findViewById(R.id.phyCheckBox3);
        //setting mental goals
        EditText setMenGoal = findViewById(R.id.setMenGoal);
        CheckBox menDaily = findViewById(R.id.menCheckBox);
        CheckBox menWeekly = findViewById(R.id.menCheckBox2);
        CheckBox menMonthly = findViewById(R.id.menCheckBox3);
        //setting social goals
        EditText setSocGoal = findViewById(R.id.setPhyGoal);
        CheckBox socDaily = findViewById(R.id.socCheckBox);
        CheckBox socWeekly = findViewById(R.id.socCheckBox2);
        CheckBox socMonthly = findViewById(R.id.socCheckBox3);

        //submit button -> saves data on a Json object
        Button submit = findViewById(R.id.submitBtn);

        //link to homepage and Journal
        Button homepageLink = findViewById(R.id.linkHome);
        Button jounalLink = findViewById(R.id.linkJournal);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phyGoal = setPhyGoal.getText().toString();
                String menGoal = setMenGoal.getText().toString();
                String socGoal = setSocGoal.getText().toString();

                try {
                    writeFile("Info.txt",phyGoal,menGoal,socGoal); //filename:info.txt
                    Intent launch = new Intent(getApplicationContext(), Display.class);
                    startActivity(launch);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        homepageLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dash = new Intent(GoalPage.this, HomePage.class);
                startActivity(dash);
            }
        });

        jounalLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dash = new Intent(GoalPage.this, JournalPage.class);
                startActivity(dash);
            }
        });
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestAppPermissions() {
        //  if (hasReadPermissions() && hasWritePermissions()) {
        if (hasWritePermissions()) {

            return;
        }
        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 0);
    }

    public void writeFile(String filename,String phyGoal,String menGoal, String socGoal) throws JSONException, FileNotFoundException {
        /*
        What is JSONException?
        Thrown to indicate a problem with the JSON API. Such problems include:

            Attempts to parse or construct malformed documents
            Use of null as a name
            Use of numeric types not available to JSON, such as NaNs or infinities.
            Lookups using an out of range index or nonexistent name
            Type mismatches on lookups
         */
        String myDir = Environment.getExternalStorageDirectory() +"/Documents/"+filename; //creating a file in the internal storage/Documents folder on phone.
        Log.d("PrintDir","====="+myDir);
        File file = new File(myDir);    //creating a file object
        JSONObject actJSON = new JSONObject();   //create a JSONObject
        actJSON.put("Phyiscal Goal",phyGoal);
        actJSON.put("Mental Goal",menGoal);
        actJSON.put("Social Goal",socGoal);

        //Write to the file and store in internal storage
        FileOutputStream fOut = new FileOutputStream(file, true); //create a file output stream for writing data to file
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);  //converts character stream into byte stream
        try {
            myOutWriter.append(actJSON.toString() + "\n");  //write JSONObject to file
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e){
            e.printStackTrace();  //to handle exceptions and errors.
        }

    }

}