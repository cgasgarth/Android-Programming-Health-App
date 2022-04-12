package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProgressTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracker);
    }


    public void ReturnHome(View view){
        Intent homeIntent = new Intent(this, HomePage.class);
        startActivity(homeIntent);
    }

    public void GoRecommendations(View view){
        Intent recIntent = new Intent(this, RecommendationPage.class);
        startActivity(recIntent);
    }
}