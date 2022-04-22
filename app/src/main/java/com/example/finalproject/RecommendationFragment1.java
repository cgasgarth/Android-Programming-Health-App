package com.example.finalproject;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import android.widget.TextView;


public class RecommendationFragment1 extends Fragment {

    public RecommendationFragment1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    @NonNull
    public static RecommendationFragment1 newInstance() {
        RecommendationFragment1 fragment = new RecommendationFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recommendation1, container, false);
        TextView txt = v.findViewById(R.id.social);
        txt.setText("Talk about your feelings. Talking about your feelings can help you stay in good mental health and deal with times when you feel troubled. ...\n" +
                "Keep active.\n" +
                "Eat well.\n" +
                "Keep in touch.\n" +
                "Ask for help.\n" +
                "Take a break.\n" +
                "Do something you're good at.");
        return v;
    }

}
