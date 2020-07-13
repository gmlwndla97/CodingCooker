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

public class hamburger2 extends AppCompatActivity {
    SoundPool clicksound;
    SoundPool sound;
    int soundId;
    int soundId2;
    private Runnable mRunnable;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger2);


        sound=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId=sound.load(this,R.raw.touchsound,1);
        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);

        mRunnable=new Runnable(){
            @Override
            public void run() {

                ImageView warning=(ImageView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);
                //warning.setVisibility(View.INVISIBLE);

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
                    if ((!(hamburger2.this).isFinishing()) && ((hamburger2.this) != null)) {
                        Intent intent=new Intent(hamburger2.this, hamburger_timeover.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        }.start();
    }
    public void onBackPressed() {
    }

    //전역변수
    String firstimg=null;
    String secondimg=null;
    String thirdimg=null;
    String fourthimg=null;
    String fifthimg=null;
    String sixthimg=null;

    //정답은 빵 고기 상추 치즈 토마토 빵

    boolean check=false;
    int count=0;
    public void onClicked(View args){
        //sound.play(soundId,3f,3f,0,0,1f);


        ImageView firstimage=(ImageView) findViewById(R.id.imageView11);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView9);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView4);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView2);
        ImageView sixthimage=(ImageView) findViewById(R.id.imageView);


        ImageView firstfood=(ImageView) findViewById(R.id.first);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.fourth);
        ImageView fifthfood=(ImageView) findViewById(R.id.fifth);
        ImageView sixthfood=(ImageView) findViewById(R.id.last);

        count++;
        sound.play(soundId,3f,3f,0,0,1f);

        if(count==1){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                firstimage.setImageResource(R.drawable.putbread);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.bread);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                firstimage.setImageResource(R.drawable.putlettuce);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.lettuce);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3){
                firstimage.setImageResource(R.drawable.putpatty);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.patty);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                firstimage.setImageResource(R.drawable.putcheese);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.cheese);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="cheese";
            }

            else if(((ImageButton)args).getId()==R.id.imageButton5){
                firstimage.setImageResource(R.drawable.puttomato);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.tomato);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="tomato";
            }

            secondimage.setVisibility(View.VISIBLE);

        }

        else if(count==2){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                secondimage.setImageResource(R.drawable.putbread);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.bread);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                secondimage.setImageResource(R.drawable.putlettuce);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.lettuce);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3){
                secondimage.setImageResource(R.drawable.putpatty);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.patty);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                secondimage.setImageResource(R.drawable.putcheese);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.cheese);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="cheese";
            }

            else if(((ImageButton)args).getId()==R.id.imageButton5){
                secondimage.setImageResource(R.drawable.puttomato);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.tomato);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="tomato";
            }

            thirdimage.setVisibility(View.VISIBLE);


        }
        else if(count==3){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                thirdimage.setImageResource(R.drawable.putbread);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.bread);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                thirdimage.setImageResource(R.drawable.putlettuce);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.lettuce);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3) {
                thirdimage.setImageResource(R.drawable.putpatty);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.patty);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg = "patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                thirdimage.setImageResource(R.drawable.putcheese);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.cheese);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg="cheese";
            }

            else if(((ImageButton)args).getId()==R.id.imageButton5){
                thirdimage.setImageResource(R.drawable.puttomato);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.tomato);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg="tomato";
            }
            fourthimage.setVisibility(View.VISIBLE);
        }
        else if(count==4){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                fourthimage.setImageResource(R.drawable.putbread);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.bread);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                fourthimage.setImageResource(R.drawable.putlettuce);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.lettuce);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3){
                fourthimage.setImageResource(R.drawable.putpatty);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.patty);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                fourthimage.setImageResource(R.drawable.putcheese);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.cheese);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="cheese";
            }

            else if(((ImageButton)args).getId()==R.id.imageButton5){
                fourthimage.setImageResource(R.drawable.puttomato);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.tomato);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="tomato";
            }
            fifthimage.setVisibility(View.VISIBLE);

        }


        else if(count==5){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                fifthimage.setImageResource(R.drawable.putbread);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.bread);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                fifthimage.setImageResource(R.drawable.putlettuce);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.lettuce);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3){
                fifthimage.setImageResource(R.drawable.putpatty);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.patty);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg="patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                fifthimage.setImageResource(R.drawable.putcheese);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.cheese);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg="cheese";
            }


            else if(((ImageButton)args).getId()==R.id.imageButton5){
                fifthimage.setImageResource(R.drawable.puttomato);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.tomato);
                fifthfood.setVisibility(View.VISIBLE);
                fifthimg="tomato";
            } sixthimage.setVisibility(View.VISIBLE);
        }



        else if(count==6){
            if(((ImageButton)args).getId()==R.id.imageButton2){
                sixthimage.setImageResource(R.drawable.putbread);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.upperbread); //맨 위에 빵 덮는그림으로 바꿔야
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg="bread";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton4){
                sixthimage.setImageResource(R.drawable.putlettuce);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.lettuce);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg="lettuce";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton3){
                sixthimage.setImageResource(R.drawable.putpatty);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.patty);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg="patty";
            }
            else if(((ImageButton)args).getId()==R.id.imageButton){
                sixthimage.setImageResource(R.drawable.putcheese);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.cheese);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg="cheese";
            }


            else if(((ImageButton)args).getId()==R.id.imageButton5){
                sixthimage.setImageResource(R.drawable.puttomato);
                sixthimage.setVisibility(View.VISIBLE);
                sixthfood.setImageResource(R.drawable.tomato);
                sixthfood.setVisibility(View.VISIBLE);
                sixthimg="tomato";
            }
        }
    }



    public void onBackClicked(View v){
        clicksound.play(soundId2,1f,1f,0,0,1f);
        ImageView firstimage=(ImageView) findViewById(R.id.imageView11);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView9);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView4);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView2);
        ImageView sixthimage=(ImageView) findViewById(R.id.imageView);


        ImageView firstfood=(ImageView) findViewById(R.id.first);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.fourth);
        ImageView fifthfood=(ImageView) findViewById(R.id.fifth);
        ImageView sixthfood=(ImageView) findViewById(R.id.last);

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

    // 빵 고기 상추 치즈 토마토 빵
    public void onSubmitClicked(View v){
        check=true;
        clicksound.play(soundId2,1f,1f,0,0,1f);
        if(firstimg=="bread"&&secondimg=="patty"&&thirdimg=="lettuce"&&fourthimg=="cheese"&&fifthimg=="tomato"&&sixthimg=="bread"){
            Intent intent=new Intent(hamburger2.this, hamburger_clear.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(hamburger2.this, hamburger_fail.class);
            startActivity(intent);
            finish();
        }

    }


}