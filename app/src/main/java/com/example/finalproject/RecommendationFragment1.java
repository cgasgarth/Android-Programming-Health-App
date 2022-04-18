package com.example.finalproject;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;




import android.widget.Button;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class RecommendationFragment1 extends Fragment implements View.OnClickListener {

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
        Button b = (Button) v.findViewById(R.id.close);
        b.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                close(v);
        }
    }


    public void close(View view){
        getParentFragmentManager().beginTransaction()
                .remove(RecommendationFragment1.this).commit();
    }

}



