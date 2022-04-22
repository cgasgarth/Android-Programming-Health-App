package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void update(View view){
        DBClass db = new DBClass(this, "Info");
        long dob = 0;
        SharedPreferences sharedpreferences = getSharedPreferences("Details", MODE_PRIVATE);
        String user_val = sharedpreferences.getString("Username","No name");
        CalendarView calendarView = findViewById(R.id.calendarView);
        dob = calendarView.getDate();
        try{
            db.updateDOB(user_val, dob);
            Toast.makeText(this, "DOB updated",
                    Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void toHomePage(View view){
        Intent homePage = new Intent(this, HomePage.class);
        startActivity(homePage);
    }
}