package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Editprofile_Activity extends AppCompatActivity {
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile_);

        btn_save=(Button) findViewById(R.id.btn_edit);
        btn_save.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backtodashboardfn();

            }
        });
    }

    public void backtodashboardfn() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}