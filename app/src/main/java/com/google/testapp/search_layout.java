package com.google.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class search_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_layout);
        getSupportActionBar().hide();
        // Xử lý nút back
        ((ImageView)findViewById(R.id.btnBackSearch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(search_layout.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}