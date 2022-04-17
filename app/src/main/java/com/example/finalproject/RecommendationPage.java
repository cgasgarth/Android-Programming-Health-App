package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecommendationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation_page);
    }

    public void openMentalFrag(View view){
        Bundle bundle = new Bundle();


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, RecommendationFragment1.class,
                        bundle, "RecommendationFragment1")
                .commit();
    }
    public void openSocialFrag(View view){
        Bundle bundle = new Bundle();


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, RecommendationFragment2.class,
                        bundle,"RecommendationFragment2")
                .commit();
    }
    public void openPhysicalFrag(View view){
        Bundle bundle = new Bundle();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, RecommendationFragment3.class,
                        bundle, "RecommendationFragment3")
                .commit();
    }

    public void ReturnHome(View view){
        Intent homeIntent = new Intent(this, HomePage.class);
        startActivity(homeIntent);
    }
}
