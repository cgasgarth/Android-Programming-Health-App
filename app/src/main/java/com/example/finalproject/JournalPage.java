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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class JournalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_page);

        Button submitJournal = findViewById(R.id.submitButton2);
        Button linkToHome = findViewById(R.id.returnButton);
        EditText EnterNotes = findViewById(R.id.EnterNotesTV);
        CheckBox phyCheck = findViewById(R.id.checkBox1);
        CheckBox menCheck = findViewById(R.id.checkBox2);
        CheckBox socCheck = findViewById(R.id.checkBox3);
        CheckBox noTime = findViewById(R.id.noTime);
        CheckBox depressed = findViewById(R.id.depressed);
        CheckBox unWell = findViewById(R.id.unwell);
        linkToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dash = new Intent(JournalPage.this, HomePage.class);
                startActivity(dash);
            }
        });
        submitJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNotes = EnterNotes.getText().toString();
                toastMsg("Your results are submited!");

                if (phyCheck.isChecked()){
                    String phyCheckBox = phyCheck.getText().toString();

                    try {
                        writeFile("Info.txt",phyCheckBox); //filename:info.txt

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (menCheck.isChecked()){
                    String menCheckBox = menCheck.getText().toString();

                    try {
                        writeFile("Info.txt",menCheckBox); //filename:info.txt

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (socCheck.isChecked()){
                    String socCheckbox = socCheck.getText().toString();
                    try {
                        writeFile("Info.txt",socCheckbox); //filename:info.txt

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (noTime.isChecked()){
                    String noTimeCheck = noTime.getText().toString();
                    try {
                        writeFile("Info.txt",noTimeCheck); //filename:info.txt

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    writeFile("Info.txt",textNotes); //filename:info.txt

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void toastMsg(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
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

    public void writeFile(String filename,String phyGoal) throws JSONException, FileNotFoundException {
        /*
        What is JSONException?
        Thrown to indicate a problem with the JSON API. Such problems include:

            Attempts to parse or construct malformed documents
            Use of null as a name
            Use of numeric types not available to JSON, such as NaNs or infinities.
            Lookups using an out of range index or nonexistent name
            Type mismatches on lookups
         */
        String myDir = Environment.getExternalStorageDirectory() + "/Documents/" + filename; //creating a file in the internal storage/Documents folder on phone.
        Log.d("PrintDir", "=====" + myDir);
        File file = new File(myDir);    //creating a file object
        JSONObject actJSON = new JSONObject();   //create a JSONObject
        actJSON.put("Jounrnal Notes", phyGoal);
//        actJSON.put("Mental Goal", menGoal);
//        actJSON.put("Social Goal", socGoal);

        //Write to the file and store in internal storage
        FileOutputStream fOut = new FileOutputStream(file, true); //create a file output stream for writing data to file
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);  //converts character stream into byte stream
        try {
            myOutWriter.append(actJSON.toString() + "\n");  //write JSONObject to file
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();  //to handle exceptions and errors.
        }
    }



    public void ReturnHome(View view){
        Intent returnHome = new Intent(this, HomePage.class);
        startActivity(returnHome);
    }

    public void informationStoring(View view){

        Intent QIDIntent = new Intent(this, QIDPageOne.class);
        startActivity(QIDIntent);
    }

}
