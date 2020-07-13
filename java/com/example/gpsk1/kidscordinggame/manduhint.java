package com.example.gpsk1.kidscordinggame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import java.util.Random;

public class manduhint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manduhint);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Random r = new Random();
                int number=r.nextInt(2)+1;

                if(number==1){
                    Intent intent = new Intent(manduhint.this, mandu.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(number==2){
                    Intent intent = new Intent(manduhint.this, mandu2.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
            }
        },5000); //5초 있다가 힌트창 사라져요! 

    }
    public void onBackPressed() {
    }
}
