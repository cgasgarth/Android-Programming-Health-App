package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Arrays;

public class QIDPageEleven extends AppCompatActivity {
    public int[] answers = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_eleven);
    }


    public void setAnswerVals(View view){

        RadioButton R1 = findViewById(R.id.Q14R1); //Set of buttons and if else for each radio group
        RadioButton R2 = findViewById(R.id.Q14R2);
        RadioButton R3 = findViewById(R.id.Q14R3);
        RadioButton R4 = findViewById(R.id.Q14R4);
        boolean B1 = R1.isChecked();
        boolean B2 = R2.isChecked();
        boolean B3 = R3.isChecked();
        boolean B4 = R4.isChecked();
        if (B1){ answers[0] = 0; }
        else if (B2){ answers[0] = 1; }
        else if (B3){ answers[0] = 2; }
        else if (B4){ answers[0] = 3; }

        R1 = findViewById(R.id.Q15R1);
        R2 = findViewById(R.id.Q15R2);
        R3 = findViewById(R.id.Q15R3);
        R4 = findViewById(R.id.Q15R4);
        B1 = R1.isChecked();
        B2 = R2.isChecked();
        B3 = R3.isChecked();
        B4 = R4.isChecked();
        if (B1){ answers[1] = 0; }
        else if (B2){ answers[1] = 1; }
        else if (B3){ answers[1] = 2; }
        else if (B4){ answers[1] = 3; }


        int max = Arrays.stream(answers).max().getAsInt(); //find the max of our answers
        QIDPageOne.answerVals[7] = max; //Then place in answer vals

    }
    public void lastPage(View view) {
        Intent lastPage = new Intent(this, QIDPageEleven.class); //Check that it is set to correct page
        startActivity(lastPage);
    }


    public void nextPage(View view) {
        setAnswerVals(view); //this is called only when we hit the next button
        RadioGroup RG1 = findViewById(R.id.RG1); //You will have to add ID's to radio groups in XML file
        RadioGroup RG2 = findViewById(R.id.RG2);
        if( (RG1.getCheckedRadioButtonId() == -1) || (RG2.getCheckedRadioButtonId() == -1)) {
//            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
//            TV.setText("Please fill out all questions");
        }
        else {
//            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
//            TV.setText("");
            Intent nextPage = new Intent(this, QIDPageTwelve.class); //Check that it is set to correct page
            startActivity(nextPage);
        }
    }
}