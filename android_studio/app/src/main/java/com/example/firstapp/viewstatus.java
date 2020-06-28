package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.example.firstapp.MainActivity.Key_at;
import static com.example.firstapp.MainActivity.Key_roll;
//import static com.example.firstapp.applyop.Key_oid;

public class viewstatus extends AppCompatActivity {
    TextView status, remark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstatus);

        status = (TextView) findViewById(R.id.textView4);
        remark = (TextView) findViewById(R.id.textView5);

        Intent intent=getIntent();
        String srollno= intent.getStringExtra(Key_roll);
        final String access_token= intent.getStringExtra(Key_at);
        //String oid= intent.getStringExtra(Key_oid);

        RequestQueue queue = Volley.newRequestQueue(this);
        //String url =""+"?oid="+oid;
        String url ="";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //status.setText(""+ response.getString("status"));
                        //remark.setText(""+ response.getString("remark"));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        status.setText("");
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                // Basic Authentication
                //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);

                headers.put("Authorization", "Bearer " + access_token);
                return headers;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}