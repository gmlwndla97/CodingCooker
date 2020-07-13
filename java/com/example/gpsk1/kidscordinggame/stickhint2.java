package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class stickhint2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickhint2);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(stickhint2.this, stick2.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        },5000);

    }
    public void onBackPressed() {
    }
}