package com.example.gpsk1.kidscordinggame;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    SoundPool sound;
    int soundId;


    private static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mp==null){
            mp= MediaPlayer.create(this,R.raw.mainsong);
        }


        if(mp.isLooping()==false){

            mp.setLooping(true);
            mp.start();

        }





        sound=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId=sound.load(this,R.raw.startsound,1);

        ImageButton button=(ImageButton) findViewById(R.id.button);
        ImageButton button2=(ImageButton) findViewById(R.id.button2);
        ImageButton button3=(ImageButton) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(soundId,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this, menu.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(soundId,1f,1f,0,0,1f);

                Intent intent = new Intent(MainActivity.this, gamerule.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.stop();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();

                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
            }
        });


    }

//    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        mp.stop();
//        finish();

    }
}