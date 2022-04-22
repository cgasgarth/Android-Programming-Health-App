package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UpdatePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
    }

    public void updatePassword(View view){
        TextView passOne = findViewById(R.id.PassOne);
        TextView passTwo = findViewById(R.id.PassTwo);
        String passOneString = passOne.getText().toString();
        String passTwoString = passTwo.getText().toString();
        Log.i("Passone is", passOneString);
        DBClass db = new DBClass(this, "Info");
        if (!(passOneString.equals(passTwoString))){
            passOne.setError("Passwords do not match");
        }else if(passOneString.toLowerCase() == passOneString){
            passOne.setError("Password must contain a capital letter");
        }else{
            try {
                byte[] hashLoginPassword = messageDigest(passOneString);
                SharedPreferences sharedpreferences = getSharedPreferences("Details", MODE_PRIVATE);
                String user_val = sharedpreferences.getString("Username","No name");
                try{
                    db.updatePassword(user_val, hashLoginPassword);
                    Toast.makeText(this, "Password Updated",
                            Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

    }
    public void toHomePage(View view){
        Intent homePage = new Intent(this, HomePage.class);
        startActivity(homePage);
    }

    public byte[] messageDigest(String s) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(s.getBytes(StandardCharsets.UTF_8));
    }
}