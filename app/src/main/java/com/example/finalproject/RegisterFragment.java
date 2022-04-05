package com.example.finalproject;

import android.content.Intent;
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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    EditText nameET;
    EditText dobET;
    EditText genderET;
    EditText userET;
    EditText passET;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DB_KEY = "DB_KEY";
    private static Serializable db;

    public RegisterFragment() {
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
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        Button b = (Button) v.findViewById(R.id.submitButton);
        b.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.closeButton);
        b.setOnClickListener(this);
        nameET = v.findViewById(R.id.nameET);
        dobET = v.findViewById(R.id.dobET);
        genderET = v.findViewById(R.id.genderET);
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
            case R.id.closeButton:
                close(v);
                break;
        }
    }

    public void register(View view){
        String name;
        String dob;
        String gender;
        String user;
        String pass;

        if(nameET.getText() != null){ name = nameET.getText().toString(); }
        else { name = "NOT_ENTERED"; }

        if(dobET.getText() != null){ dob = dobET.getText().toString(); }
        else { dob = "NOT_ENTERED"; }

        if(genderET.getText() != null){ gender = genderET.getText().toString(); }
        else { gender = "NOT_ENTERED"; }

        if(userET.getText() != null){ user = userET.getText().toString(); }
        else { user = "NOT_ENTERED"; }

        if(passET.getText() != null){ pass = passET.getText().toString(); }
        else { pass = "NOT_ENTERED"; }

        DBClass db = MainActivity.db;
        byte[] hashPassword = new byte[0];
        Boolean passCheck = true;
        if(pass.toLowerCase() == pass ){ passCheck = false; }


//        if(pass != "" & user != "" & gender != "" & dob != "" & name != ""&
//                user.length() > 4 & passCheck){
            if(true){
            try{
                hashPassword = messageDigest(pass);
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            db.addInfo(1, name, dob, gender, hashPassword ,user);
        }else{
                    passET.setError("Every space must be completed, the password must be " +
                            "contain a capital letter, and the username " +
                            "must be 4 or more characters");
        }

        Toast.makeText(getContext().getApplicationContext(), "You have registered",
                Toast.LENGTH_LONG).show();
    }
    public void close(View view){
        getParentFragmentManager().beginTransaction()
                .remove(RegisterFragment.this).commit();
    }

    public byte[] messageDigest(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(s.getBytes(StandardCharsets.UTF_8));
    }
}