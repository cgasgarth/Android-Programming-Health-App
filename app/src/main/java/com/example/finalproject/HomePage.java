package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SharedPreferences sharedpreferences = getSharedPreferences("Details", MODE_PRIVATE);
        String name_val = sharedpreferences.getString("Name","No name");
        TextView tv = findViewById(R.id.welcomeTV);
        tv.setText(name_val);
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

    public void toAlarm(View view){
        Intent alarmMain = new Intent(this, AlarmsPage.class);
        startActivity(alarmMain);
    }

}
