package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracker);
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(50);
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
