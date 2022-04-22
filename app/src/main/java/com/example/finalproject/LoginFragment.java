package com.example.finalproject;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
        Button b = v.findViewById(R.id.submitButton);
        b.setOnClickListener(this);
        b = v.findViewById(R.id.closeButton);
        b.setOnClickListener(this);
        requestAppPermissions();
        userET = v.findViewById(R.id.userET);
        passET = v.findViewById(R.id.passET);
        // Inflate the layout for this fragment
        return v;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitButton:
                login();
                break;
            case R.id.closeButton:
                close();
                break;
        }
    }

    public void login(){
        String user;
        String pass;

        if(userET.getText().toString() != ""){ user = userET.getText().toString(); }
        else { user = "NOT_ENTERED"; }

        if(passET.getText().toString() != ""){ pass = passET.getText().toString(); }
        else { pass = "NOT_ENTERED"; }

        try{
            byte[] hashLoginPassword = messageDigest(pass);
            Log.i("hashed is", hashLoginPassword.toString());
            DBClass db = MainActivity.db;
            String cond = "username=" + '"' + user + '"';
            try{
                byte[] getHashedPassword = db.getHash("password_val", "Users", cond);

                if (Arrays.equals(hashLoginPassword, getHashedPassword)) {
                    cond = "username=" + '"' + user + '"';
                    String getName = db.selectConditionQuery("name", cond);

                    SharedPreferences sharedPreferences =
                        this.getActivity().getSharedPreferences("Details", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", getName);
                    editor.putString("Username", user);
                    editor.commit();

                    Intent intent = new Intent(getContext(), HomePage.class);
                    startActivity(intent);
                }else{
                    passET.setError("The Password is not valid");
                }
            }catch (Exception e){ userET.setError("The Username is not valid"); }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public void close(){
        getParentFragmentManager().beginTransaction()
                .remove(LoginFragment.this).commit();
    }

    public byte[] messageDigest(String s) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(s.getBytes(StandardCharsets.UTF_8));
    }

    public void writeFile(String filename,String name) throws JSONException, FileNotFoundException {
        /*
        What is JSONException?
        Thrown to indicate a problem with the JSON API. Such problems include:

            Attempts to parse or construct malformed documents
            Use of null as a name
            Use of numeric types not available to JSON, such as NaNs or infinities.
            Lookups using an out of range index or nonexistent name
            Type mismatches on lookups
         */
        String myDir = Environment.getExternalStorageDirectory() +"/Documents/"+filename; //creating a file in the internal storage/Documents folder on phone.
        Log.d("PrintDir","====="+myDir);
        File file = new File(myDir);    //creating a file object
        JSONObject actJSON = new JSONObject();   //create a JSONObject
        actJSON.put("Name",name);

        //Write to the file and store in internal storage
        FileOutputStream fOut = new FileOutputStream(file, true); //create a file output stream for writing data to file
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);  //converts character stream into byte stream
        try {
            myOutWriter.append(actJSON.toString() + "\n");  //write JSONObject to file
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e){
            e.printStackTrace();  //to handle exceptions and errors.
        }

    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestAppPermissions() {
        //  if (hasReadPermissions() && hasWritePermissions()) {
        if (hasWritePermissions()) {

            return;
        }
        ActivityCompat.requestPermissions(getActivity(),
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 0);
    }
}