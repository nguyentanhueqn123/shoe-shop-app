package com.google.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class FlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);
        getSupportActionBar().hide();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(500);
                    startActivity(new Intent(FlashScreen.this,MainActivity.class));
                    finish();
                }catch (Exception e){

                }
            }
        };thread.start();
    }
}