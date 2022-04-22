package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QIDPageTwelve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_twelve);

        TextView score = findViewById(R.id.textView9);
        score.setText(yourScore(QIDPageOne.answerVals)); //using extra, method 2
    }

    public String yourScore(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        return String.valueOf(sum);
    }

    public void lastPage(View view) {
        Intent lastPage = new Intent(this, QIDPageTwelve.class); //Check that it is set to correct page
        startActivity(lastPage);
    }

    public void BackHomePage(View view) {
        Intent HomePage = new Intent(this, HomePage.class); //Check that it is set to correct page
        startActivity(HomePage);
    }



}