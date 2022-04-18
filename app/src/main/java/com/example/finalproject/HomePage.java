package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }

    public void Logout(View view){
        finish();
        System.exit(0);
    }

    public void ProgressTracker(View view){
        Intent Progress = new Intent(this, ProgressTracker.class);
        startActivity(Progress);
    }

    public void GoRecommendations(View view){
        Intent recIntent = new Intent(this, RecommendationPage.class);
        startActivity(recIntent);
    }

}