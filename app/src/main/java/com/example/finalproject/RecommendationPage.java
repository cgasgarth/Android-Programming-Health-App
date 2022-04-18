package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation_page);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Button btnphysical = findViewById(R.id.FragPhysical);
        btnphysical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, RecommendationFragment2.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });


        /// code for next button

        Button btnsocial = findViewById(R.id.FragSocial);
        btnsocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, RecommendationFragment3.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });

        /// code for next button
        Button btnmental = findViewById(R.id.FragMental);
        btnmental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, RecommendationFragment1.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
    }




    public void ReturnHome(View view){
        Intent homeIntent = new Intent(this, HomePage.class);
        startActivity(homeIntent);


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
