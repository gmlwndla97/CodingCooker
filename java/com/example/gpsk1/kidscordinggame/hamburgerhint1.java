package com.example.gpsk1.kidscordinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import java.util.Random;


public class hamburgerhint1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburgerhint1);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(hamburgerhint1.this, hamburger1.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        },5000);


    }
    public void onBackPressed() {
    }
}
