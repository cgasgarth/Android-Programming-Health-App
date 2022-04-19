package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QIDPageThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_three);
    }
    public void increase(View view) {
        Intent nextPage = new Intent(this, QIDPageFourIncreased.class); //Check that it is set to correct page
        startActivity(nextPage);
    }
    public void decrease(View view) {
        Intent nextPage = new Intent(this, QIDPageFourDecreased.class); //Check that it is set to correct page
        startActivity(nextPage);
    }
    public void lastPage(View view) {
        Intent lastPage = new Intent(this, QIDPageTwo.class); //Check that it is set to correct page
        startActivity(lastPage);
    }
}