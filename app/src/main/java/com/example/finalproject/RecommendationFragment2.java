package com.example.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecommendationFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendationFragment2 extends Fragment {


    public RecommendationFragment2() {
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
        View v = inflater.inflate(R.layout.fragment_recommendation2, container, false);
        TextView txt = v.findViewById(R.id.physical);
        txt.setText("Sleep. It's common knowledge that most people need 8 hours of sleep a night to stay healthy and alert. ...\n" +
                "Eating Well.\n" +
                "Physical Activity.\n" +
                "Hygiene.\n" +
                "Relaxation");


        return v;
    }

}
