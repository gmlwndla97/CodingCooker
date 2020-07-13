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
import java.util.Random;

public class menu extends AppCompatActivity {

    SoundPool clicksound;
    int soundId2;



    private static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton hamburger=(ImageButton) findViewById(R.id.hamburger);
        ImageButton mandu=(ImageButton) findViewById(R.id.mandu);
        ImageButton stick=(ImageButton) findViewById(R.id.stick);

        ImageButton back=(ImageButton) findViewById(R.id.home);


        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);

        hamburger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clicksound.play(soundId2,1f,1f,0,0,1f);


                Random r=new Random();
                int number=r.nextInt(3)+1;
                if(number==1){
                    Intent intent=new Intent(menu.this, hamburgerhint1.class);
                    startActivity(intent);
                }
                else if(number==2){
                    Intent intent=new Intent(menu.this, hamburgerhint2.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(menu.this, hamburgerhint3.class);
                    startActivity(intent);
                }
                finish();
            }
        });


        //만두는 시험삼아서 한 거
        mandu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clicksound.play(soundId2,1f,1f,0,0,1f);
                Intent intent=new Intent(menu.this, manduhint.class);
                startActivity(intent);
                finish();
            }
        });


        stick.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clicksound.play(soundId2,1f,1f,0,0,1f);

                Random r3=new Random();
                int number3=r3.nextInt(3)+1;
                if(number3==1){
                    Intent intent=new Intent(menu.this, stickhint1.class);
                    startActivity(intent);
                }
                else if(number3==2){
                    Intent intent=new Intent(menu.this, stickhint2.class);
                    startActivity(intent);
                }
                else if(number3==3) {
                    Intent intent=new Intent(menu.this, stickhint3.class);
                    startActivity(intent);
                }
                finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clicksound.play(soundId2,1f,1f,0,0,1f);
                Intent intent=new Intent(menu.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });


    }
        public void onBackPressed() {


    }
}
