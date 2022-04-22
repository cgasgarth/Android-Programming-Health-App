package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class QIDPageNine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_nine);
    }
    public void setAnswerVals(View view){

        RadioButton R1 = findViewById(R.id.Q12R1); //Set of buttons and if else for each radio group
        RadioButton R2 = findViewById(R.id.Q12R2); //Make sure to update values of the radio buttons
        RadioButton R3 = findViewById(R.id.Q12R3);
        RadioButton R4 = findViewById(R.id.Q12R4);
        Boolean B1 = R1.isChecked();
        Boolean B2 = R2.isChecked();
        Boolean B3 = R3.isChecked();
        Boolean B4 = R4.isChecked();
        if (B1){ QIDPageOne.answerVals[5] = 0; } //Make sure to update position in answerVals array
        else if (B2){ QIDPageOne.answerVals[5] = 1; }
        else if (B3){ QIDPageOne.answerVals[5] = 2; }
        else if (B4){ QIDPageOne.answerVals[5] = 3; }
    }

    public void lastPage(View view) {
        Intent lastPage = new Intent(this, QIDPageEight.class); //Check that it is set to correct page
        startActivity(lastPage);
    }

    public void nextPage(View view) {
        setAnswerVals(view); //this is called only when we hit the next button
        RadioGroup RG = findViewById(R.id.RG1); //You will have to add ID's to radio groups in XML file
        if( RG.getCheckedRadioButtonId() == -1) {
//            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
//            TV.setText("Please fill out all questions");
        }
        else {
//            TextView TV = findViewById(R.id.AlertText); //Add textview to every page to display message
//            TV.setText("");
            Intent nextPage = new Intent(this, QIDPageTen.class); //Check that it is set to correct page
            startActivity(nextPage);
        }
    }
}