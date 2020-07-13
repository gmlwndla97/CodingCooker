package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class stick_timeover extends AppCompatActivity {
    SoundPool clicksound;
    int soundId2;
    private static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick_timeover);

        mp= MediaPlayer.create(this,R.raw.failsound);
        mp.setLooping(false);
        mp.start();

        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);

    }
    public void onBackPressed() {
    }
    public void onClicked(View args) {

        clicksound.play(soundId2,3f,3f,0,0,1f);
        Random r=new Random();
        int number=r.nextInt(3)+1;


        if(((ImageButton)args).getId()==R.id.restart){
            if(number==1){
                Intent intent=new Intent(stick_timeover.this, stickhint1.class);
                startActivity(intent);
            }
            if(number==2){
                Intent intent=new Intent(stick_timeover.this, stickhint2.class);
                startActivity(intent);
            }
            if(number==3){
                Intent intent=new Intent(stick_timeover.this, stickhint3.class);
                startActivity(intent);
            }
            finish();
        }
        else if(((ImageButton)args).getId()==R.id.stop){
            Intent intent=new Intent(stick_timeover.this, menu.class);
            startActivity(intent);
            finish();
        }
    }
}