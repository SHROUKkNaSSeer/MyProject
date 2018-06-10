package com.example.shrouk.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;import android.view.View;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void re2(View view) {
        Intent i = new Intent(this,profile.class);
        startActivity(i);
    }
}

    /**
     * Id to identity READ_CONTACTS permission request.
     */

