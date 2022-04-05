package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    EditText userET;
    EditText passET;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DB_KEY = "DB_KEY";
    private static Serializable db;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DB_KEY, db);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            db = getArguments().getString(DB_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        Button b = (Button) v.findViewById(R.id.submitButton);
        b.setOnClickListener(this);
        userET = v.findViewById(R.id.userET);
        passET = v.findViewById(R.id.passET);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitButton:
                register(v);
                break;
        }
    }

    public void register(View view){
        String user;
        String pass;

        if(userET.getText() != null){ user = userET.getText().toString(); }
        else { user = "NOT_ENTERED"; }

        if(passET.getText() != null){ pass = passET.getText().toString(); }
        else { pass = "NOT_ENTERED"; }


        Log.i("username is ", user);


        Toast.makeText(getContext().getApplicationContext(), "You have logged in",
                Toast.LENGTH_LONG).show();


        getParentFragmentManager().beginTransaction()
                .remove(LoginFragment.this).commit();
    }
}