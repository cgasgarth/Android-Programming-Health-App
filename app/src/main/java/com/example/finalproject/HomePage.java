package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SharedPreferences sharedpreferences = getSharedPreferences("Details", MODE_PRIVATE);
        String name_val = sharedpreferences.getString("Name","No name");
        name_val = "Welcome " + name_val;
        TextView tv = findViewById(R.id.welcomeTV);
        tv.setText(name_val);
    }

    public void Logout(View view){
        SharedPreferences sharedpreferences =
                getSharedPreferences("Details", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove("Name"); // will delete key Name
        editor.commit();

        finish();
        System.exit(0);
    }

    public void ProgressTracker(View view){
        Intent Progress = new Intent(this, ProgressTracker.class);
        startActivity(Progress);
    }

    public void Recommendations(View view){
        Intent goToRec = new Intent(this, RecommendationPage.class);
        startActivity(goToRec);
    }



    public void toAlarm(View view){
        Intent alarmMain = new Intent(this, AlarmsPage.class);
        startActivity(alarmMain);
    }

    public void qidPage(View view){
        Intent QIDIntent = new Intent(this, QIDPageOne.class);
        startActivity(QIDIntent);
    }

}
