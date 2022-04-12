package com.example.bike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static int city=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        Button seoul = (Button) findViewById(R.id.bike) ;
        seoul.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)  {
                Intent intent=new Intent(MainActivity.this, bike_seoul.class);
                MainActivity.this.startActivity(intent);
                city=1;

            }
        });


        Button gwangyang = (Button) findViewById(R.id.bike_gwangyang) ;
        gwangyang.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)  {
                Intent intent=new Intent(MainActivity.this, bike_seoul.class);
                MainActivity.this.startActivity(intent);
                city=6;

            }
        });





    }








}







