package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.firstapp.MainActivity.Key_at;
import static com.example.firstapp.MainActivity.Key_roll;
import static com.example.firstapp.MainActivity.Key_name;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    TextView txtV;
    TextView passlefttxt;
    TextView num , textView9;
    ImageView imgV;
    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnA = (Button) findViewById(R.id.applyforoutpassesbtn);
        btnB = (Button) findViewById(R.id.previousoutpassesbtn);
        btnC = (Button) findViewById(R.id.editprofilebtn);
        btnD = (Button) findViewById(R.id.viewstatusbtn);
        signout=(Button) findViewById(R.id.signout);
        txtV = (TextView) findViewById(R.id.dashboardtext);
        textView9 = (TextView) findViewById(R.id.textView9);
        passlefttxt = (TextView) findViewById(R.id.passeslefttxt);
        num = (TextView) findViewById(R.id.numbern);
        imgV = (ImageView) findViewById(R.id.logoimage);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener( this);
        signout.setOnClickListener(this);
        Intent intent=getIntent();
        String srollno= intent.getStringExtra(Key_roll);
        String access_token= intent.getStringExtra(Key_at);
        String sname= intent.getStringExtra(Key_name);

        textView9.setText("Welcome, "+ sname);

    }
    @Override
    public void onClick(View v) {

            btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String leftpasses=num.getText().toString();
                    if(!leftpasses.equals("0")) {
                        openapplyopfn();
                    }
                    else{
                        Toast t = Toast.makeText(DashboardActivity.this , "You don't have any GatePass Left", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            });
            btnB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openprevopfn();

                }
            });
            btnC.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    editprofilefn();
                }
            });
            btnD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String leftpasses=num.getText().toString();
                    if(!leftpasses.equals("0")) {
                        openviewstatusfn();
                    }
                    else{
                        Toast t = Toast.makeText(DashboardActivity.this , "You don't have any GatePass Left", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    //openviewstatusfn();
                }
            });
            signout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openloginpagefn();
                }
            });


        }
    public void openprevopfn() {
        Intent intent = new Intent(this, prevop.class);
        startActivity(intent);

    }
    public void editprofilefn(){
        Intent intent=new Intent(this,Editprofile_Activity.class);
        startActivity(intent);
    }
    public void openviewstatusfn(){
        Intent intent=new Intent(this,viewstatus.class);
        startActivity(intent);
    }
    public void openapplyopfn(){
        Intent intent=new Intent(this, applyop.class);
        startActivity(intent);
    }
    public void openloginpagefn(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}