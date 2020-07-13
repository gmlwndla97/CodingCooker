package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class stick3 extends AppCompatActivity {
    SoundPool clicksound;
    int soundId2;
    SoundPool sound;
    int soundId;
    private Runnable mRunnable;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick3);


        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);
        sound=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId=sound.load(this,R.raw.touchsound,1);
        mRunnable=new Runnable(){
            @Override
            public void run() {

                ImageView warning=(ImageView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);

            }
        };


        mHandler=new Handler();
        mHandler.postDelayed(mRunnable,25000);

        new CountDownTimer(30000,1000){
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(check==false) {
                    if((!(stick3.this).isFinishing())&&((stick3.this)!=null)){
                        Intent intent=new Intent(stick3.this, stick_timeover.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }
        }.start();

        ImageView firstfood = (ImageView) findViewById(R.id.last);
        ImageView secondfood = (ImageView) findViewById(R.id.second);
        ImageView thirdfood = (ImageView) findViewById(R.id.third);
        ImageView fourthfood = (ImageView) findViewById(R.id.first);
        ImageView fifthfood = (ImageView) findViewById(R.id.fourth);
        ImageView sixthfood = (ImageView) findViewById(R.id.imageView11);


        firstfood.bringToFront();
        secondfood.bringToFront();
        thirdfood.bringToFront();
        fourthfood.bringToFront();
        fifthfood.bringToFront();
        sixthfood.bringToFront();

    }
    public void onBackPressed() {
    }

    boolean check=false;
    String firstimg=null;
    String secondimg=null;
    String thirdimg=null;
    String fourthimg=null;
    String fifthimg=null;
    String sixthimg=null;
    int count=0;
    //정답은 파인애플 딸기 사과 키위 파인애플 체리


    public void onClicked(View args){
        sound.play(soundId,3f,3f,0,0,1f);


        ImageView firstimage=(ImageView) findViewById(R.id.imageView);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView2);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView4);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView44);
        ImageView sixthimage=(ImageView) findViewById(R.id.imageView444);


        ImageView firstfood=(ImageView) findViewById(R.id.last);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.first);
        ImageView fifthfood=(ImageView) findViewById(R.id.fourth);
        ImageView sixthfood=(ImageView) findViewById(R.id.imageView11);
        count++;

        if(count==1) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                firstimage.setImageResource(R.drawable.putkiwi);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.kiwi);
                firstfood.setVisibility(View.VISIBLE);
                firstimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                firstimage.setImageResource(R.drawable.putstrawberry);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.strawberry);
                firstfood.setVisibility(View.VISIBLE);
                firstimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                firstimage.setImageResource(R.drawable.putcherry);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.cherry);
                firstfood.setVisibility(View.VISIBLE);
                firstimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                firstimage.setImageResource(R.drawable.putpineapple);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.pineapple);
                firstfood.setVisibility(View.VISIBLE);
                firstimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                firstimage.setImageResource(R.drawable.putapple);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.apple);
                firstfood.setVisibility(View.VISIBLE);
                firstimg = "apple";
            }


            secondimage.setVisibility(View.VISIBLE);

        }

        if(count==2) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                secondimage.setImageResource(R.drawable.putkiwi);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.kiwi);
                secondfood.setVisibility(View.VISIBLE);
                secondimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                secondimage.setImageResource(R.drawable.putstrawberry);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.strawberry);
                secondfood.setVisibility(View.VISIBLE);
                secondimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                secondimage.setImageResource(R.drawable.putcherry);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.cherry);
                secondfood.setVisibility(View.VISIBLE);
                secondimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                secondimage.setImageResource(R.drawable.putpineapple);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.pineapple);
                secondfood.setVisibility(View.VISIBLE);
                secondimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                secondimage.setImageResource(R.drawable.putapple);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.apple);
                secondfood.setVisibility(View.VISIBLE);
                secondimg = "apple";
            }
            thirdimage.setVisibility(View.VISIBLE);
        }


        if(count==3) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                thirdimage.setImageResource(R.drawable.putkiwi);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.kiwi);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                thirdimage.setImageResource(R.drawable.putstrawberry);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.strawberry);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                thirdimage.setImageResource(R.drawable.putcherry);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.cherry);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                thirdimage.setImageResource(R.drawable.putpineapple);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.pineapple);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                thirdimage.setImageResource(R.drawable.putapple);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.apple);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "apple";
            }
            fourthimage.setVisibility(View.VISIBLE);
        }


        if(count==4) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                fourthimage.setImageResource(R.drawable.putkiwi);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.kiwi);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                fourthimage.setImageResource(R.drawable.putstrawberry);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.strawberry);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                fourthimage.setImageResource(R.drawable.putcherry);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.cherry);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                fourthimage.setImageResource(R.drawable.putpineapple);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.pineapple);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                fourthimage.setImageResource(R.drawable.putapple);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.apple);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg = "apple";
            }
            fifthimage.setVisibility(View.VISIBLE);

        }


        if(count==5) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                fifthimage.setImageResource(R.drawable.putkiwi);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.kiwi);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                fifthimage.setImageResource(R.drawable.putstrawberry);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.strawberry);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                fifthimage.setImageResource(R.drawable.putcherry);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.cherry);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                fifthimage.setImageResource(R.drawable.putpineapple);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.pineapple);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                fifthimage.setImageResource(R.drawable.putapple);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.apple);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg = "apple";
            }
            sixthimage.setVisibility(View.VISIBLE);
        }


        if(count==6) {
            if (((ImageButton) args).getId() == R.id.imageButton5) {
                sixthimage.setImageResource(R.drawable.putkiwi);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.kiwi);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg = "kiwi";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton) {
                sixthimage.setImageResource(R.drawable.putstrawberry);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.strawberry);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg = "strawberry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton4) {
                sixthimage.setImageResource(R.drawable.putcherry);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.cherry);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg = "cherry";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton2) {
                sixthimage.setImageResource(R.drawable.putpineapple);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.pineapple);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg = "pineapple";
            }
            else if (((ImageButton) args).getId() == R.id.imageButton3) {
                sixthimage.setImageResource(R.drawable.putapple);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.apple);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg = "apple";
            }
        }
    }


    public void onBackClicked(View v){
        clicksound.play(soundId2,1f,1f,0,0,1f);


        ImageView firstimage=(ImageView) findViewById(R.id.imageView);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView2);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView4);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView44);
        ImageView sixthimage=(ImageView) findViewById(R.id.imageView444);

        ImageView firstfood=(ImageView) findViewById(R.id.last);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.first);
        ImageView fifthfood=(ImageView) findViewById(R.id.fourth);
        ImageView sixthfood=(ImageView) findViewById(R.id.imageView11);

        if(count==1){
            firstimage.setImageResource(R.drawable.question);
            firstfood.setVisibility(View.INVISIBLE);
            secondimage.setVisibility(View.INVISIBLE);
            count=0;
        }
        else if(count==2){
            secondimage.setImageResource(R.drawable.question);
            secondfood.setVisibility(View.INVISIBLE);
            thirdimage.setVisibility(View.INVISIBLE);
            count=1;
        }
        else if(count==3){
            thirdimage.setImageResource(R.drawable.question);
            thirdfood.setVisibility(View.INVISIBLE);
            fourthimage.setVisibility(View.INVISIBLE);
            count=2;
        }
        else if(count==4){
            fourthimage.setImageResource(R.drawable.question);
            fourthfood.setVisibility(View.INVISIBLE);
            fifthimage.setVisibility(View.INVISIBLE);
            count=3;
        }
        else if(count==5){
            fifthimage.setImageResource(R.drawable.question);
            fifthfood.setVisibility(View.INVISIBLE);
            sixthimage.setVisibility(View.INVISIBLE);
            count=4;
        }
        else if(count==6){
            sixthimage.setImageResource(R.drawable.question);
            sixthfood.setVisibility(View.INVISIBLE);
            count=5;
        }
        else if(count>6){
            sixthimage.setImageResource(R.drawable.question);
            sixthfood.setVisibility(View.INVISIBLE);
            count=5;
        }



    }


    //정답은 파인애플 딸기 사과 키위 파인애플 체리
    public void onSubmitClicked(View v){
        clicksound.play(soundId2,1f,1f,0,0,1f);

        check=true;

        if(firstimg=="pineapple"&&secondimg=="strawberry"&&thirdimg=="apple"&&fourthimg=="kiwi"&&fifthimg=="pineapple"&&sixthimg=="cherry"){
            Intent intent=new Intent(stick3.this, stick_clear.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(stick3.this, stick_fail.class);
            startActivity(intent);
            finish();
        }


    }
}