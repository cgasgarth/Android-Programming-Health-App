package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

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

        name = nameET.getText().toString();
        dob = " ";
        try {
            dob = dobET.getText().toString();
            Scanner sc = new Scanner(dob).useDelimiter("/");
            dob = sc.next();
            dob = dob + sc.next();
            dob = dob + sc.next();
        } catch (Exception e) {
            dobET.setError("Please format the DOB Correctly");
        }


        gender = genderET.getText().toString();
        user = userET.getText().toString();
        pass = passET.getText().toString();

        DBClass db = MainActivity.db;
        byte[] hashPassword = new byte[0];
        Boolean passCheck = true;
        if(pass.toLowerCase() == pass ){ passCheck = false; }


        if(pass != "" & user != "" & gender != "" & dob != "" & name != ""&
                user.length() >= 4 & passCheck){
            try{
                hashPassword = messageDigest(pass);
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            db.addInfo(name, dob, gender, hashPassword ,user);
            getParentFragmentManager().beginTransaction()
                    .remove(RegisterFragment.this).commit();

            Toast.makeText(getContext().getApplicationContext(), "You have registered",
                    Toast.LENGTH_LONG).show();
        }else{
                    passET.setError("Every space must be completed, the password must " +
                            "contain a capital letter, and the username " +
                            "must be 4 or more characters");
        }

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