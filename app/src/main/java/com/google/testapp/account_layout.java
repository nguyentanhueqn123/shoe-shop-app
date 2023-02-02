package com.google.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class account_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_layout);
        getSupportActionBar().hide();
    }
}