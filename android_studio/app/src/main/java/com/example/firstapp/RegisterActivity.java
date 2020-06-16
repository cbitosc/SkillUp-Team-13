package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText username,Branch2,number,email,phone,password1,password2;
    TextView loginview;
    RadioGroup radioGroup2;
    RadioButton radio_1,radio_2,radio_3,radio_4;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        Branch2 = (EditText) findViewById(R.id.Branch2);
        number = (EditText) findViewById(R.id.number);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        btn_register = (Button) findViewById(R.id.btn_register);
        loginview = (TextView) findViewById(R.id.loginview);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radio_1 = (RadioButton) findViewById(R.id.radio_1);
        radio_2 = (RadioButton) findViewById(R.id.radio_2);
        radio_3 = (RadioButton) findViewById(R.id.radio_3);
        radio_4 = (RadioButton) findViewById(R.id.radio_4);


        loginview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}