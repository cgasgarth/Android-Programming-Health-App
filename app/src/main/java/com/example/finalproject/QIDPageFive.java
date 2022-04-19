package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QIDPageFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidpage_five);
    }
    public void increase(View view) {
        Intent nextPage = new Intent(this, QIDPageSixWeightIncrease.class); //Check that it is set to correct page
        startActivity(nextPage);
    }
    public void decrease(View view) {
        Intent nextPage = new Intent(this, QIDPageSixWeightDecrease.class); //Check that it is set to correct page
        startActivity(nextPage);
    }
    public void lastPage(View view) {
        Intent lastPage = new Intent(this, QIDPageThree.class); //Check that it is set to correct page
        startActivity(lastPage);
    }
}