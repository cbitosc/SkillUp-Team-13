package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText Roll_No,password;
    TextView textView;
    Button btn_login;
    private RequestQueue queue;
    JsonObjectRequest objectRequest;
    static final String Key_roll="srollno";
    static final String Key_Password="spassword";
    private String srollno;
    private String spassword;
    JSONObject data;
    boolean isEmpty
            (EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered() {
        if (isEmpty(Roll_No)) {
            password.setError("");
            Toast t = Toast.makeText(this, "You must enter your Roll Number!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(password)) {
            password.setError("Password is required!");
        }
        else{
            userLogin();
            queue.add(objectRequest);
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
    public void userLogin()
    {
        srollno = Roll_No.getText().toString().trim();
        spassword = password.getText().toString().trim();
        String URL = "https://outpassapp.herokuapp.com/studentlogin";
        data = new JSONObject();
        try {
            data.put(Key_roll,srollno);
            data.put(Key_Password,spassword);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.e("qwert",data.toString());
        queue = Volley.newRequestQueue(this);
        objectRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Toast toast =
                                    Toast.makeText(getApplicationContext(),response.getString("access_token"),Toast.LENGTH_LONG);
                            toast.show();
                            opendashboardfn();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override

                    public void onErrorResponse(VolleyError error) {

                        Toast toast =
                                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
        {

            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(Key_roll,srollno);
                params.put(Key_Password,spassword);
                return params;
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

        };

    }
    public void opendashboardfn(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

}