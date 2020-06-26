package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static com.example.firstapp.MainActivity.Key_at;
import static com.example.firstapp.MainActivity.Key_roll;

public class viewstatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstatus);

        Intent intent=getIntent();
        String srollno= intent.getStringExtra(Key_roll);
        String access_token= intent.getStringExtra(Key_at);
    }
}