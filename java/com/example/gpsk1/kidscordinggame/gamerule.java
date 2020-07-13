package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class gamerule extends AppCompatActivity {
    SoundPool clicksound;
    int soundId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamerule);

        ImageButton start=(ImageButton) findViewById(R.id.start);
        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clicksound.play(soundId2,1f,1f,0,0,1f);
                Intent intent=new Intent(gamerule.this, menu.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void onBackPressed() {


    }

}
