package com.example.shrouk.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class secondseen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondseen);
    }

    public void log1(View view) {
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }

    public void reg1(View view) {
        Intent i = new Intent(this,Register.class);
        startActivity(i);
    }
}
