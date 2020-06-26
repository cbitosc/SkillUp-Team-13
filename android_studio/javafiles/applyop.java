package com.example.firstapp;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.firstapp.MainActivity.Key_at;
import static com.example.firstapp.MainActivity.Key_roll;

public class applyop extends AppCompatActivity {
    int SELECT_PHOTO=1;
    Uri uri;
    Button aply,choose;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyop);
        choose= (Button) findViewById(R.id.upload);
        imageView=(ImageView) findViewById(R.id.image_view);
        aply=(Button) findViewById(R.id.applybutton);

        Intent intent=getIntent();
        String srollno= intent.getStringExtra(Key_roll);
        String access_token= intent.getStringExtra(Key_at);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_PHOTO);
            }
        });
        aply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotodashboardfn();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==SELECT_PHOTO && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            uri=data.getData();
            try{
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void gotodashboardfn(){
        Intent intent=new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }

}