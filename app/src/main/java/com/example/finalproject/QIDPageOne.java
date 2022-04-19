package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



public class QIDPageOne extends AppCompatActivity {
    public static String uname;
    public int[] answers = new int[4]; //This is needed to store answers then find
    public static int[] answerVals = new int[10]; // When putting in answerVals
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_one);
    }
    public void setAnswerVals(View view){

        RadioButton R1 = findViewById(R.id.Q1R1); //Set of buttons and if else for each radio group
        RadioButton R2 = findViewById(R.id.Q1R2);
        RadioButton R3 = findViewById(R.id.Q1R3);
        RadioButton R4 = findViewById(R.id.Q1R4);
        Boolean B1 = R1.isChecked();
        Boolean B2 = R2.isChecked();
        Boolean B3 = R3.isChecked();
        Boolean B4 = R4.isChecked();
        if (B1){ answers[0] = 0; }
        else if (B2){ answers[0] = 1; }
        else if (B3){ answers[0] = 2; }
        else if (B4){ answers[0] = 3; }

        R1 = findViewById(R.id.Q2R1);
        R2 = findViewById(R.id.Q2R2);
        R3 = findViewById(R.id.Q2R3);
        R4 = findViewById(R.id.Q2R4);
        B1 = R1.isChecked();
        B2 = R2.isChecked();
        B3 = R3.isChecked();
        B4 = R4.isChecked();
        if (B1){ answers[1] = 0; }
        else if (B2){ answers[1] = 1; }
        else if (B3){ answers[1] = 2; }
        else if (B4){ answers[1] = 3; }

        R1 = findViewById(R.id.Q3R1);
        R2 = findViewById(R.id.Q3R2);
        R3 = findViewById(R.id.Q3R3);
        R4 = findViewById(R.id.Q3R4);
        B1 = R1.isChecked();
        B2 = R2.isChecked();
        B3 = R3.isChecked();
        B4 = R4.isChecked();
        if (B1){ answers[2] = 0; }
        else if (B2){ answers[2] = 1; }
        else if (B3){ answers[2] = 2; }
        else if (B4){ answers[2] = 3; }

        R1 = findViewById(R.id.Q4R1);
        R2 = findViewById(R.id.Q4R2);
        R3 = findViewById(R.id.Q4R3);
        R4 = findViewById(R.id.Q4R4);
        B1 = R1.isChecked();
        B2 = R2.isChecked();
        B3 = R3.isChecked();
        B4 = R4.isChecked();
        if (B1){ answers[3] = 0; }
        else if (B2){ answers[3] = 1; }
        else if (B3){ answers[3] = 2; }
        else if (B4){ answers[3] = 3; }

        int max = Arrays.stream(answers).max().getAsInt(); //find the max of our answers
        answerVals[0] = max; //Then place in answer vals

    }
    public void nextPage(View view) {
        RadioGroup Q1RG = findViewById(R.id.RG1); //You will have to add ID's to radio groups in XML file
        RadioGroup Q2RG = findViewById(R.id.RG2);
        RadioGroup Q3RG = findViewById(R.id.RG3);
        RadioGroup Q4RG = findViewById(R.id.RG4);

        if( (Q1RG.getCheckedRadioButtonId() == -1) ||
                (Q2RG.getCheckedRadioButtonId() == -1) ||
                (Q3RG.getCheckedRadioButtonId() == -1) ||
                (Q4RG.getCheckedRadioButtonId() == -1) ) {
            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
            TV.setText("Please fill out all questions");
        }
        else {
            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
            TV.setText("");
            Intent nextPage = new Intent(this, QIDPageTwo.class); //Check that it is set to correct page
            startActivity(nextPage);
        }
    }
}