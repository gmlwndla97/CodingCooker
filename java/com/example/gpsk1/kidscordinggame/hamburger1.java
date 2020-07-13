package com.example.gpsk1.kidscordinggame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.CountDownTimer;




public class hamburger1 extends AppCompatActivity {
    private Runnable mRunnable;
    private Handler mHandler;
    SoundPool buttonsound;
    SoundPool clicksound;
    int soundId1;
    int soundId2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger1);


        //효과음
        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);
        buttonsound=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId1=buttonsound.load(this,R.raw.touchsound,1);



        mRunnable=new Runnable(){
            @Override
            public void run() {
                //딜레이 시간이 지나면 실행
                ImageView warning=(ImageView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);


            }
        };


        mHandler=new Handler(); //마지막 5초 카운트 세기 위한 handler변수
        mHandler.postDelayed(mRunnable,25000); //25초 딜레이

        new CountDownTimer(30000,1000){ //30초간 진행되는 게임
            @Override
            public void onTick(long l) {


            }


            @Override
            public void onFinish() { //30초가 끝나면
                if(check==false) { //제출버튼을 누르지 않고 30초가 지난경우
                    if ((!(hamburger1.this).isFinishing()) && ((hamburger1.this) != null)) {

                        Intent intent=new Intent(hamburger1.this, hamburger_timeover.class); //타임오버 결과화면
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }.start();
    }
    public void onBackPressed() { //뒤로가기 버튼 막음
    }

    boolean check=false;//제출버튼 눌렀는지 여부
    //전역변수
    String firstimg=null;
    String secondimg=null;
    String thirdimg=null;
    String fourthimg=null;
    String fifthimg=null;

    //정답은 빵 상추 치즈 고기 빵

    int count=0;
    public void onClicked(View args){

        //각 블록과 음식 그림 id설정
        ImageView firstimage=(ImageView) findViewById(R.id.imageView9);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView4);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView2);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView);


        ImageView firstfood=(ImageView) findViewById(R.id.first);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.fourth);
        ImageView fifthfood=(ImageView) findViewById(R.id.last);



        count++;


        if(count==1){ //한번 누를 때마다 id구별 후 이미지 띄움
            buttonsound.play(soundId1,3f,3f,0,0,1f);

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
            else if(((ImageButton)args).getId()==R.id.imageButtonTomato){
                firstimage.setImageResource(R.drawable.puttomato);
                firstimage.setVisibility(View.VISIBLE);
                firstfood.setImageResource(R.drawable.tomato);
                firstfood.setVisibility(View.VISIBLE);
                firstimg="tomato";
            }

            secondimage.setVisibility(View.VISIBLE);

        }

        else if(count==2){
            buttonsound.play(soundId1,3f,3f,0,0,1f);

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
            else if(((ImageButton)args).getId()==R.id.imageButtonTomato){
                secondimage.setImageResource(R.drawable.puttomato);
                secondimage.setVisibility(View.VISIBLE);
                secondfood.setImageResource(R.drawable.tomato);
                secondfood.setVisibility(View.VISIBLE);
                secondimg="tomato";
            }

            thirdimage.setVisibility(View.VISIBLE);


        }
        else if(count==3){
            buttonsound.play(soundId1,3f,3f,0,0,1f);

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
            else if(((ImageButton)args).getId()==R.id.imageButtonTomato){
                thirdimage.setImageResource(R.drawable.puttomato);
                thirdimage.setVisibility(View.VISIBLE);
                thirdfood.setImageResource(R.drawable.tomato);
                thirdfood.setVisibility(View.VISIBLE);
                thirdimg="tomato";
            }
            fourthimage.setVisibility(View.VISIBLE);


        }
        else if(count==4){
            buttonsound.play(soundId1,3f,3f,0,0,1f);

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
            else if(((ImageButton)args).getId()==R.id.imageButtonTomato){
                fourthimage.setImageResource(R.drawable.puttomato);
                fourthimage.setVisibility(View.VISIBLE);
                fourthfood.setImageResource(R.drawable.tomato);
                fourthfood.setVisibility(View.VISIBLE);
                fourthimg="tomato";
            }
            fifthimage.setVisibility(View.VISIBLE);


        }


        else if(count==5){
            buttonsound.play(soundId1,3f,3f,0,0,1f);

            if(((ImageButton)args).getId()==R.id.imageButton2){
                fifthimage.setImageResource(R.drawable.putbread);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.upperbread); //맨 위에 빵 덮는그림으로 바꿔야
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
            else if(((ImageButton)args).getId()==R.id.imageButtonTomato){
                fifthimage.setImageResource(R.drawable.puttomato);
                fifthimage.setVisibility(View.VISIBLE);
                fifthfood.setImageResource(R.drawable.tomato);
                fifthfood.setVisibility(View.VISIBLE);
                fourthimg="tomato";
            }

        }

    }

    public void onBackClicked(View v){ //재료 삭제하고 싶을 때
        clicksound.play(soundId2,1f,1f,0,0,1f);

        ImageView firstimage=(ImageView) findViewById(R.id.imageView9);
        ImageView secondimage=(ImageView) findViewById(R.id.imageView4);
        ImageView thirdimage=(ImageView) findViewById(R.id.imageView3);
        ImageView fourthimage=(ImageView) findViewById(R.id.imageView2);
        ImageView fifthimage=(ImageView) findViewById(R.id.imageView);

        ImageView firstfood=(ImageView) findViewById(R.id.first);
        ImageView secondfood=(ImageView) findViewById(R.id.second);
        ImageView thirdfood=(ImageView) findViewById(R.id.third);
        ImageView fourthfood=(ImageView) findViewById(R.id.fourth);
        ImageView fifthfood=(ImageView) findViewById(R.id.last);

        if(count==1){
            firstimage.setImageResource(R.drawable.question);
            firstfood.setVisibility(View.INVISIBLE); //해당 카운트의 이미지를 안보이게 한다
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
            count=4;
        }
        else if(count>5){
            fifthimage.setImageResource(R.drawable.question);
            fifthfood.setVisibility(View.INVISIBLE);
            count=4;
        }


    }

    public void onSubmitClicked(View v){//제출버튼을 눌렀을 때
        clicksound.play(soundId2,1f,1f,0,0,1f);

        check=true;

        //정답은 빵 상추 치즈 고기 빵
        //배열에 저장된 정답 순서와 입력 순서가 같은지 확인
        if(firstimg=="bread"&&secondimg=="lettuce"&&thirdimg=="cheese"&&fourthimg=="patty"&&fifthimg=="bread"){

            Intent intent=new Intent(hamburger1.this, hamburger_clear.class); //같으면 성공화면
            startActivity(intent);
           finish();
        }
        else{
            Intent intent=new Intent(hamburger1.this, hamburger_fail.class);//다르면 실패화면
            startActivity(intent);
            finish();
        }


    }


}