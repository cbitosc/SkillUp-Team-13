package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText username,number,email,phone,password1,password2,phone2,parentname;
    TextView loginview;
    RadioGroup radioGroup2;
    RadioButton radio_1,radio_2,radio_3,radio_4;
    Button btn_register;
    Spinner Branch2;
    private static final int MY_PASSWORD_DIALOG_ID = 4;
    boolean isEmpty
            (EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void checkDataEntered(){
        if (isEmpty(username)) {
            username.setError("You must enter your name to register!");
        }
        if (radioGroup2.getCheckedRadioButtonId() == -1)
        {
            Toast t = Toast.makeText(this, "You must select a year!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(number)) {
            number.setError("Roll number is required!");
        }
        if (isEmpty(phone)) {
            phone.setError("Phone number is required!");
        }
        if (isEmpty(phone2)) {
            phone2.setError("Parents number is required!");
        }
        if (isEmpty(parentname)) {
            parentname.setError("Parents Name is required!");
        }
        if (isEmpty(password1)) {
            password1.setError("Password is required!");
        }
        if (isEmpty(password2)) {
            password2.setError("You need to confirm Password!");
        }
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
        validatePassword();

    }

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");
    private boolean validatePassword() {
        String passwordInput = password1.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            password1.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password1.setError("Password too weak");
            return false;
        } else {
            password1.setError(null);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        number = (EditText) findViewById(R.id.number);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        phone2 = (EditText) findViewById(R.id.phone2);
        parentname = (EditText) findViewById(R.id.parentname);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        btn_register = (Button) findViewById(R.id.btn_register);
        loginview = (TextView) findViewById(R.id.loginview);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radio_1 = (RadioButton) findViewById(R.id.radio_1);
        radio_2 = (RadioButton) findViewById(R.id.radio_2);
        radio_3 = (RadioButton) findViewById(R.id.radio_3);
        radio_4 = (RadioButton) findViewById(R.id.radio_4);


        Branch2 = (Spinner) findViewById(R.id.Branch2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.branch_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Branch2.setAdapter(adapter);

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
                checkDataEntered();


            }
        });

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String passwrd = password1.getText().toString();
                if (editable.length() > 0 && passwrd.length() > 0) {
                    if(!password2 .equals(passwrd)){
                        // give an error that password and confirm password not match
                        Toast.makeText(RegisterActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}