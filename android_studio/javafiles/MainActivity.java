package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText Roll_No,password;
    TextView textView;
    Button btn_login;
    boolean isEmpty
            (EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered() {
        if (isEmpty(Roll_No)) {
            Toast t = Toast.makeText(this, "You must enter your Roll Number!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(password)) {
            password.setError("Password is required!");
        }
        else {
            opendashboardfn();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Roll_No = (EditText) findViewById(R.id.Roll_No);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        textView = (TextView) findViewById(R.id.textView);
        btn_login.setOnClickListener(this);
        textView.setOnClickListener(this);
    }
    public void onClick(View v) {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkDataEntered();
                //opendashboardfn();

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,
                        RegisterActivity.class);
                startActivity(i);

            }
        });
    }
    public void opendashboardfn(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

}