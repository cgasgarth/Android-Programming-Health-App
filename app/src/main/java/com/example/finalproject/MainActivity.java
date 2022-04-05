package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//This is going to be the login screen
public class MainActivity extends AppCompatActivity {
    public static DBClass db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBClass(this, "Info");
    }

    public void openLoginFrag(View view){
        Bundle bundle = new Bundle();
        DBClass db = new DBClass(MainActivity.this, "Info");

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, LoginFragment.class, bundle, "LoginFragment")
                .commit();
    }

    public void openRegisterFrag(View view){
        Bundle bundle = new Bundle();
        bundle.putInt("some_int", 0);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, RegisterFragment.class, bundle,
                        "RegisterFragment")
                .commit();
    }

    public void toHomePage(View view){
        Intent nextPage = new Intent(this, HomePage.class); //Check that it is set to correct page
        startActivity(nextPage);

    }
}