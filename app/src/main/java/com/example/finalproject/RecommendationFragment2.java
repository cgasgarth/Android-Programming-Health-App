package com.example.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        Button b = (Button) v.findViewById(R.id.close);
        b.setOnClickListener(this::close);

        return v;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                close(v);
        }
    }


    public void close(View view){
        getParentFragmentManager().beginTransaction()
                .remove(RecommendationFragment2.this).commit();
    }

}