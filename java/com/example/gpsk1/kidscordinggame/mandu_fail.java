package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mandu_fail extends AppCompatActivity {
    SoundPool clicksound;
    int soundId2;
    private static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandu_fail);
        mp= MediaPlayer.create(this,R.raw.failsound);
        mp.setLooping(false);
        mp.start();

        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);


        ImageButton ReStart = (ImageButton)findViewById(R.id.restart);
        ImageButton StopGame = (ImageButton)findViewById(R.id.stop);

        ReStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicksound.play(soundId2,3f,3f,0,0,1f);
                Intent intent = new Intent(mandu_fail.this, manduhint.class);
                startActivity(intent);
                finish();
            }
        });
        StopGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicksound.play(soundId2,3f,3f,0,0,1f);
                Intent intent = new Intent(mandu_fail.this, menu.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void onBackPressed() {
    }
}