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
import android.widget.Toast;
import android.widget.Button;

public class mandu extends AppCompatActivity {
    private Runnable mRunnable;
    private Handler mHandler;
    SoundPool buttonsound;
    SoundPool clicksound;
    int soundId1;
    int soundId2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandu);
        findViewById(R.id.complete).setOnClickListener(mClickListener);
       // findViewById(R.id.back).setOnClickListener(bClickListener);

        clicksound =new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId2= clicksound.load(this,R.raw.clicksound,1);
        buttonsound=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId1=buttonsound.load(this,R.raw.touchsound,1);

        mRunnable=new Runnable(){
            @Override
            public void run() {

                ImageView warning=(ImageView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);
                //warning.setVisibility(View.INVISIBLE);

            }
        };


        mHandler=new Handler();
        mHandler.postDelayed(mRunnable,25000); //30초 되기 5초전 경고창

        new CountDownTimer(30000,1000){ //30초 넘을 시 timeover
            public void onTick(long I){

            }
            public void onFinish(){
                if(completeCheck==0){
                    Intent intent = new Intent(mandu.this, mandu_timeover.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();

    }
    public void onBackPressed() { //(핸드폰)뒤로가기 버튼
    }
    int completeCheck=0;
    int answerCheck,answerCheck2=0;
    int count = 0;
    int makesokCheck, makepeeCheck, putsokCheck, makeshapeCheck, wholeRepeatCheck, boilCheck, threeCheck, fiveCheck, tenCheck = 0;
    int[] repeatCheck = new int[5];
    String[] input = new String[5];
    String[] answer = {"makesok","makepee","putsok","makeshape","repeatfiveboil"};



    public void noRepeat(int i, View args, ImageView input1,ImageView input2, ImageView show) { //반복없을때
        if (((ImageButton) args).getId() == R.id.makesok) {
            if (makesokCheck == 0) {
                input1.setImageResource(R.drawable.p1makesok);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                makesokCheck++;
                input2.setImageResource(R.drawable.quest);
                input2.setVisibility(View.VISIBLE);
                input[i]="makesok";
                show.setImageResource(R.drawable.showsok);
                show.setVisibility(View.VISIBLE);
            } else if (makesokCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.makepee) {
            if (makepeeCheck == 0) {
                input1.setImageResource(R.drawable.p2makepee);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                makepeeCheck++;
                input2.setImageResource(R.drawable.quest);
                input2.setVisibility(View.VISIBLE);
                input[i]="makepee";
                show.setImageResource(R.drawable.showpee);
                show.setVisibility(View.VISIBLE);
            } else if (makepeeCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.putsok) {
            if (putsokCheck == 0) {
                input1.setImageResource(R.drawable.p3putsok);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                putsokCheck++;
                input2.setImageResource(R.drawable.quest);
                input2.setVisibility(View.VISIBLE);
                input[i]="putsok";
                show.setImageResource(R.drawable.showputsok);
                show.setVisibility(View.VISIBLE);
            } else if (putsokCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.makeshape) {
            if (makeshapeCheck == 0) {
                input1.setImageResource(R.drawable.p4makeshape);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                makeshapeCheck++;
                input2.setImageResource(R.drawable.quest);
                input2.setVisibility(View.VISIBLE);
                input[i]="makeshape";
                show.setImageResource(R.drawable.showmakeshape);
                show.setVisibility(View.VISIBLE);
            } else if (makeshapeCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.boil) {
            if (boilCheck == 0) {
                input1.setImageResource(R.drawable.p7boil);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.boiloff);
                boilCheck++;
                input2.setImageResource(R.drawable.quest);
                input2.setVisibility(View.VISIBLE);
                input[i]="boil";
                show.setImageResource(R.drawable.showboil);
                show.setVisibility(View.VISIBLE);
            } else if (boilCheck != 0) {
                count--;
            }
        }if(((ImageButton) args).getId() == R.id.repeat||((ImageButton) args).getId() == R.id.three||
                ((ImageButton) args).getId() == R.id.five||((ImageButton) args).getId() == R.id.ten){
            input2.setVisibility(View.INVISIBLE);
        }
        if (((ImageButton) args).getId() == R.id.repeat) {
            if (wholeRepeatCheck == 0) {
                input1.setImageResource(R.drawable.p5repeat);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.repeatoff);
                wholeRepeatCheck++;
                input[i]="repeat";
                repeatCheck[i] = 1;
            } else if (wholeRepeatCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.three || ((ImageButton) args).getId() == R.id.five
                || ((ImageButton) args).getId() == R.id.ten) {
            Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
            count--;
        }
    }

    public void nMinutesRepeat(int i, View args, ImageView input2,ImageView input3,ImageView show) {//i번 반복할때 행동받기
        if (repeatCheck[i] == 3) { //3분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeatthreemakesok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeatthreemakepee";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeatthreeputsok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeatthreemakeshpae";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    input[i]="repeatthreeboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }if(((ImageButton) args).getId() == R.id.repeat||((ImageButton) args).getId() == R.id.three||
                    ((ImageButton) args).getId() == R.id.five||((ImageButton) args).getId() == R.id.ten){
                input3.setVisibility(View.INVISIBLE);
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        } else if (repeatCheck[i] == 5) { //5분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeatfivemakesok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeatfivemakepee";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeatfiveputsok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeatfivemakeshape";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    input[i]="repeatfiveboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }if(((ImageButton) args).getId() == R.id.repeat||((ImageButton) args).getId() == R.id.three||
                    ((ImageButton) args).getId() == R.id.five||((ImageButton) args).getId() == R.id.ten){
                input3.setVisibility(View.INVISIBLE);
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        } else if (repeatCheck[i] == 10) { //10분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeattenmakesok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeattenmakepee";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeattenputsok";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeattenmakeshape";
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input3.setImageResource(R.drawable.quest);
                    input3.setVisibility(View.VISIBLE);
                    input[i]="repeattenboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }if(((ImageButton) args).getId() == R.id.repeat||((ImageButton) args).getId() == R.id.three||
                    ((ImageButton) args).getId() == R.id.five||((ImageButton) args).getId() == R.id.ten){
                input3.setVisibility(View.INVISIBLE);
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        }
    }

    public void getMinutes(int i, View args, ImageView input1) {
        if (((ImageButton) args).getId() == R.id.makesok || ((ImageButton) args).getId() == R.id.makepee ||
                ((ImageButton) args).getId() == R.id.putsok || ((ImageButton) args).getId() == R.id.makeshape ||
                ((ImageButton) args).getId() == R.id.boil || ((ImageButton) args).getId() == R.id.repeat) {
            Toast.makeText(this, "시간을 먼저 선택해야해!", Toast.LENGTH_SHORT).show();
            count--;
        } else if (((ImageButton) args).getId() == R.id.three) {
            if (threeCheck == 0) {
                input1.setImageResource(R.drawable.p6repeat3);
                input1.setVisibility(View.VISIBLE);
                repeatCheck[i] = 3;
                input[i]="repeatthree";
                ((ImageButton) args).setImageResource(R.drawable.threeoff);
            } else count--;
        } else if (((ImageButton) args).getId() == R.id.five) {
            if (fiveCheck == 0) {
                input1.setImageResource(R.drawable.p6repeat5);
                input1.setVisibility(View.VISIBLE);
                repeatCheck[i] = 5;
                input[i]="repeatfive";
                ((ImageButton) args).setImageResource(R.drawable.fiveoff);
            } else count--;
        } else if (((ImageButton) args).getId() == R.id.ten) {
            if(tenCheck==0){
            input1.setImageResource(R.drawable.p6repeat10);
            input1.setVisibility(View.VISIBLE);
            repeatCheck[i] = 10;
                input[i]="repeatten";
            ((ImageButton) args).setImageResource(R.drawable.tenoff);
        } else count--;}
    }

    public void noRepeatLast(int i, View args, ImageView input1,ImageView show){
        if (((ImageButton) args).getId() == R.id.makesok) {
            if (makesokCheck == 0) {
                input1.setImageResource(R.drawable.p1makesok);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                makesokCheck++;
                input[i]="makesok";
                show.setImageResource(R.drawable.showsok);
                show.setVisibility(View.VISIBLE);
            } else if (makesokCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.makepee) {
            if (makepeeCheck == 0) {
                input1.setImageResource(R.drawable.p2makepee);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                makepeeCheck++;
                input[i]="makepee";
                show.setImageResource(R.drawable.showpee);
                show.setVisibility(View.VISIBLE);
            } else if (makepeeCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.putsok) {
            if (putsokCheck == 0) {
                input1.setImageResource(R.drawable.p3putsok);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                putsokCheck++;
                input[i]="putsok";
                show.setImageResource(R.drawable.showputsok);
                show.setVisibility(View.VISIBLE);
            } else if (putsokCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.makeshape) {
            if (makeshapeCheck == 0) {
                input1.setImageResource(R.drawable.p4makeshape);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                makeshapeCheck++;
                input[i]="makeshape";
                show.setImageResource(R.drawable.showmakeshape);
                show.setVisibility(View.VISIBLE);
            } else if (makeshapeCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.boil) {
            if (boilCheck == 0) {
                input1.setImageResource(R.drawable.p7boil);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.boiloff);
                boilCheck++;
                input[i]="boil";
                show.setImageResource(R.drawable.showboil);
                show.setVisibility(View.VISIBLE);
            } else if (boilCheck != 0) {
                count--;
            }
        }
        if (((ImageButton) args).getId() == R.id.repeat) {
            if (wholeRepeatCheck == 0) {
                input1.setImageResource(R.drawable.p5repeat);
                input1.setVisibility(View.VISIBLE);
                ((ImageButton) args).setImageResource(R.drawable.repeatoff);
                wholeRepeatCheck++;
                input[i]="repeat";
                repeatCheck[i] = 1;
            } else if (wholeRepeatCheck != 0) {
                count--;
            }
        } else if (((ImageButton) args).getId() == R.id.three || ((ImageButton) args).getId() == R.id.five
                || ((ImageButton) args).getId() == R.id.ten) {
            Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
            count--;
        }
    }

    public void nMinutesRepeatLast(int i, View args, ImageView input2,ImageView show){
        if (repeatCheck[i] == 3) { //3분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeatthreemakesok";
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeatthreemakepee";
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeatthreeputsok";
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeatthreemakeshape";
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat3boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input[i]="repeatthreeboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        } else if (repeatCheck[i] == 5) { //5분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeatfivemakesok";
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeatfivemakepee";
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeatfiveputsok";
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeatfivemakeshape";
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat5boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input[i]="repeatfiveboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        } else if (repeatCheck[i] == 10) { //10분반복
            if (((ImageButton) args).getId() == R.id.makesok) {
                if (makesokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makesok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makesokoff);
                    makesokCheck++;
                    input[i]="repeattenmakesok";
                    show.setImageResource(R.drawable.showsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makepee) {
                if (makepeeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makepee);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makepeeoff);
                    makepeeCheck++;
                    input[i]="repeattenmakepee";
                    show.setImageResource(R.drawable.showpee);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.putsok) {
                if (putsokCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10putsok);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.putsokoff);
                    putsokCheck++;
                    input[i]="repeattenputsok";
                    show.setImageResource(R.drawable.showputsok);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.makeshape) {
                if (makeshapeCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10makeshape);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.makeshapeoff);
                    makeshapeCheck++;
                    input[i]="repeattenmakeshape";
                    show.setImageResource(R.drawable.showmakeshape);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }  else if (((ImageButton) args).getId() == R.id.boil) {
                if (boilCheck == 0) {
                    input2.setImageResource(R.drawable.p7repeat10boil);
                    input2.setVisibility(View.VISIBLE);
                    ((ImageButton) args).setImageResource(R.drawable.boiloff);
                    boilCheck++;
                    input[i]="repeattenboil";
                    show.setImageResource(R.drawable.showboil);
                    show.setVisibility(View.VISIBLE);
                } else count--;
            }
            if (((ImageButton) args).getId() == R.id.repeat) {
                if (wholeRepeatCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.three) {
                if (threeCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.five) {
                if (fiveCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            } else if (((ImageButton) args).getId() == R.id.ten) {
                if (tenCheck == 0) {
                    Toast.makeText(this, "여기 올 수 없어!", Toast.LENGTH_SHORT).show();
                    count--;
                } else count--;
            }
        }
    }

    public void noRepeatBack (int i,View args, ImageView input1,ImageView input2,ImageView show){
        ImageButton makesok = (ImageButton)findViewById(R.id.makesok);
        ImageButton makepee = (ImageButton)findViewById(R.id.makepee);
        ImageButton putsok = (ImageButton)findViewById(R.id.putsok);
        ImageButton makeshape = (ImageButton)findViewById(R.id.makeshape);
        ImageButton boil = (ImageButton)findViewById(R.id.boil);
        ImageButton repeat = (ImageButton)findViewById(R.id.repeat);
        ImageButton three = (ImageButton)findViewById(R.id.three);
        ImageButton five = (ImageButton)findViewById(R.id.five);
        ImageButton ten = (ImageButton)findViewById(R.id.ten);

            input1.setImageResource(R.drawable.quest);
            input1.setVisibility(View.VISIBLE);
            input2.setVisibility(View.INVISIBLE);
            if(input[i]=="makesok"||input[i]=="repeatthreemakesok"||input[i]=="repeatfivemakesok"
                    ||input[i]=="repeattenmakesok") {
                makesokCheck=0;
                makesok.setImageResource(R.drawable.makesok);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="makepee"||input[i]=="repeatthreemakepee"||input[i]=="repeatfivemakepee"
                    ||input[i]=="repeattenmakepee") {
                makepeeCheck=0;
                makepee.setImageResource(R.drawable.makepee);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="putsok"||input[i]=="repeatthreeputsok"||input[i]=="repeatfiveputsok"
                    ||input[i]=="repeattenputsok") {
                putsokCheck=0;
                putsok.setImageResource(R.drawable.putsok);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="makeshape"||input[i]=="repeatthreemakeshape"||input[i]=="repeatfivemakeshape"
                    ||input[i]=="repeattenmakeshape"){
                makeshapeCheck=0;
                makeshape.setImageResource(R.drawable.makeshape);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="boil"||input[i]=="repeatthreeboil"||input[i]=="repeatfiveboil"
                    ||input[i]=="repeattenboil") {
                boilCheck=0;
                boil.setImageResource(R.drawable.boil);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="repeat") {
                wholeRepeatCheck=0;
                repeat.setImageResource(R.drawable.repeat);
                repeatCheck[i]=0;
            }
            if(input[i]=="repeatthree") {
                threeCheck=0;
            }
            if(input[i]=="repeatfive") {
                fiveCheck=0;
            }
            if(input[i]=="repeatten") {
                tenCheck=0;
            }
        }

    public void repeatBack (int i,View args, ImageView input1,ImageView show){
        ImageButton makesok = (ImageButton)findViewById(R.id.makesok);
        ImageButton makepee = (ImageButton)findViewById(R.id.makepee);
        ImageButton putsok = (ImageButton)findViewById(R.id.putsok);
        ImageButton makeshape = (ImageButton)findViewById(R.id.makeshape);
        ImageButton boil = (ImageButton)findViewById(R.id.boil);
        ImageButton repeat = (ImageButton)findViewById(R.id.repeat);
        ImageButton three = (ImageButton)findViewById(R.id.three);
        ImageButton five = (ImageButton)findViewById(R.id.five);
        ImageButton ten = (ImageButton)findViewById(R.id.ten);

            input1.setImageResource(R.drawable.quest);
            input1.setVisibility(View.VISIBLE);
            if(input[i]=="makesok"||input[i]=="repeatthreemakesok"||input[i]=="repeatfivemakesok"
                    ||input[i]=="repeattenmakesok") {
                makesokCheck=0;
                makesok.setImageResource(R.drawable.makesok);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="makepee"||input[i]=="repeatthreemakepee"||input[i]=="repeatfivemakepee"
                    ||input[i]=="repeattenmakepee") {
                makepeeCheck=0;
                makepee.setImageResource(R.drawable.makepee);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="putsok"||input[i]=="repeatthreeputsok"||input[i]=="repeatfiveputsok"
                    ||input[i]=="repeattenputsok") {
                putsokCheck=0;
                putsok.setImageResource(R.drawable.putsok);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="makeshape"||input[i]=="repeatthreemakeshape"||input[i]=="repeatfivemakeshape"
                    ||input[i]=="repeattenmakeshape"){
                makeshapeCheck=0;
                makeshape.setImageResource(R.drawable.makeshape);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="boil"||input[i]=="repeatthreeboil"||input[i]=="repeatfiveboil"
                    ||input[i]=="repeattenboil") {
                boilCheck=0;
                boil.setImageResource(R.drawable.boil);
                show.setVisibility(View.INVISIBLE);
            }
            if(input[i]=="repeat") {
                wholeRepeatCheck=0;
                repeat.setImageResource(R.drawable.repeat);
                repeatCheck[i]=0;
            }
            if(input[i]=="repeatthree") {
                threeCheck=0;
            }
            if(input[i]=="repeatfive") {
                fiveCheck=0;
            }
            if(input[i]=="repeatten") {
                tenCheck=0;
            }
        }

    public void getMinutesBack (int i,View args, ImageView input1,ImageView show){
        ImageButton makesok = (ImageButton)findViewById(R.id.makesok);
        ImageButton makepee = (ImageButton)findViewById(R.id.makepee);
        ImageButton putsok = (ImageButton)findViewById(R.id.putsok);
        ImageButton makeshape = (ImageButton)findViewById(R.id.makeshape);
        ImageButton boil = (ImageButton)findViewById(R.id.boil);
        ImageButton repeat = (ImageButton)findViewById(R.id.repeat);
        ImageButton three = (ImageButton)findViewById(R.id.three);
        ImageButton five = (ImageButton)findViewById(R.id.five);
        ImageButton ten = (ImageButton)findViewById(R.id.ten);

            if(repeatCheck[i]==3){
                input1.setImageResource(R.drawable.p5repeat);
                show.setVisibility(View.INVISIBLE);
                three.setImageResource(R.drawable.three);
                repeatCheck[i]=1;
                input[i]="repeat";
            }
            else if(repeatCheck[i]==5){
                input1.setImageResource(R.drawable.p5repeat);
                show.setVisibility(View.INVISIBLE);
                five.setImageResource(R.drawable.five);
                repeatCheck[i]=1;
                input[i]="repeat";
            }
            else if(repeatCheck[i]==10){
                input1.setImageResource(R.drawable.p5repeat);
                show.setVisibility(View.INVISIBLE);
                ten.setImageResource(R.drawable.ten);
                repeatCheck[i]=1;
                input[i]="repeat";
            }
        }

    public void nMinutesRepeatBack (int i,View args, ImageView input1,ImageView input2,ImageView show) {
        ImageButton makesok = (ImageButton) findViewById(R.id.makesok);
        ImageButton makepee = (ImageButton) findViewById(R.id.makepee);
        ImageButton putsok = (ImageButton) findViewById(R.id.putsok);
        ImageButton makeshape = (ImageButton) findViewById(R.id.makeshape);
        ImageButton boil = (ImageButton) findViewById(R.id.boil);
        ImageButton repeat = (ImageButton) findViewById(R.id.repeat);
        ImageButton three = (ImageButton) findViewById(R.id.three);
        ImageButton five = (ImageButton) findViewById(R.id.five);
        ImageButton ten = (ImageButton) findViewById(R.id.ten);
            if (input[i] == "repeatthreemakesok") {
                input1.setImageResource(R.drawable.p6repeat3);
                show.setVisibility(View.INVISIBLE);
                makesok.setImageResource(R.drawable.makesok);
                makesokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatthree";
            }
            if (input[i] == "repeatthreemakepee") {
                input1.setImageResource(R.drawable.p6repeat3);
                show.setVisibility(View.INVISIBLE);
                makepee.setImageResource(R.drawable.makepee);
                makepeeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatthree";
            }
            if (input[i] == "repeatthreeputsok") {
                input1.setImageResource(R.drawable.p6repeat3);
                show.setVisibility(View.INVISIBLE);
                putsok.setImageResource(R.drawable.putsok);
                putsokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatthree";
            }
            if (input[i] == "repeatthreemakeshape") {
                input1.setImageResource(R.drawable.p6repeat3);
                show.setVisibility(View.INVISIBLE);
                makeshape.setImageResource(R.drawable.makeshape);
                makeshapeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatthree";
            }
            if (input[i] == "repeatthreeboil") {
                input1.setImageResource(R.drawable.p6repeat3);
                show.setVisibility(View.INVISIBLE);
                boil.setImageResource(R.drawable.boil);
                boilCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatthree";
            }
            if (input[i] == "repeatfivemakesok") {
                input1.setImageResource(R.drawable.p6repeat5);
                show.setVisibility(View.INVISIBLE);
                makesok.setImageResource(R.drawable.makesok);
                makesokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatfive";
            }
            if (input[i] == "repeatfivemakepee") {
                input1.setImageResource(R.drawable.p6repeat5);
                show.setVisibility(View.INVISIBLE);
                makepee.setImageResource(R.drawable.makepee);
                makepeeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatfive";
            }
            if (input[i] == "repeatfiveputsok") {
                input1.setImageResource(R.drawable.p6repeat5);
                show.setVisibility(View.INVISIBLE);
                putsok.setImageResource(R.drawable.putsok);
                putsokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatfive";
            }
            if (input[i] == "repeatfivemakeshape") {
                input1.setImageResource(R.drawable.p6repeat5);
                show.setVisibility(View.INVISIBLE);
                makeshape.setImageResource(R.drawable.makeshape);
                makeshapeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatfive";
            }
            if (input[i] == "repeatfiveboil") {
                input1.setImageResource(R.drawable.p6repeat5);
                show.setVisibility(View.INVISIBLE);
                boil.setImageResource(R.drawable.boil);
                boilCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatfive";
            }
            if (input[i] == "repeattenmakesok") {
                input1.setImageResource(R.drawable.p6repeat10);
                show.setVisibility(View.INVISIBLE);
                makesok.setImageResource(R.drawable.makesok);
                makesokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatten";
            }
            if (input[i] == "repeattenmakepee") {
                input1.setImageResource(R.drawable.p6repeat10);
                show.setVisibility(View.INVISIBLE);
                makepee.setImageResource(R.drawable.makepee);
                makepeeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatten";
            }
            if (input[i] == "repeattenputsok") {
                input1.setImageResource(R.drawable.p6repeat10);
                show.setVisibility(View.INVISIBLE);
                putsok.setImageResource(R.drawable.putsok);
                putsokCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatten";
            }
            if (input[i] == "repeattenmakeshape") {
                input1.setImageResource(R.drawable.p6repeat10);
                show.setVisibility(View.INVISIBLE);
                makeshape.setImageResource(R.drawable.makeshape);
                makeshapeCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatten";
            }
            if (input[i] == "repeattenboil") {
                input1.setImageResource(R.drawable.p6repeat10);
                show.setVisibility(View.INVISIBLE);
                boil.setImageResource(R.drawable.boil);
                boilCheck = 0;
                input2.setVisibility(View.INVISIBLE);
                input[i]="repeatten";
            }
        }

    public void nMinutesRepeatLastBack (int i,View args, ImageView input1,ImageView show) {
        ImageButton makesok = (ImageButton) findViewById(R.id.makesok);
        ImageButton makepee = (ImageButton) findViewById(R.id.makepee);
        ImageButton putsok = (ImageButton) findViewById(R.id.putsok);
        ImageButton makeshape = (ImageButton) findViewById(R.id.makeshape);
        ImageButton boil = (ImageButton) findViewById(R.id.boil);
        ImageButton repeat = (ImageButton) findViewById(R.id.repeat);
        ImageButton three = (ImageButton) findViewById(R.id.three);
        ImageButton five = (ImageButton) findViewById(R.id.five);
        ImageButton ten = (ImageButton) findViewById(R.id.ten);
        if (input[i] == "repeatthreemakesok") {
            input1.setImageResource(R.drawable.p6repeat3);
            show.setVisibility(View.INVISIBLE);
            makesok.setImageResource(R.drawable.makesok);
            makesokCheck = 0;
            input[i]="repeatthree";
        }
        if (input[i] == "repeatthreemakepee") {
            input1.setImageResource(R.drawable.p6repeat3);
            show.setVisibility(View.INVISIBLE);
            makepee.setImageResource(R.drawable.makepee);
            makepeeCheck = 0;

            input[i]="repeatthree";
        }
        if (input[i] == "repeatthreeputsok") {
            input1.setImageResource(R.drawable.p6repeat3);
            show.setVisibility(View.INVISIBLE);
            putsok.setImageResource(R.drawable.putsok);
            putsokCheck = 0;

            input[i]="repeatthree";
        }
        if (input[i] == "repeatthreemakeshape") {
            input1.setImageResource(R.drawable.p6repeat3);
            show.setVisibility(View.INVISIBLE);
            makeshape.setImageResource(R.drawable.makeshape);
            makeshapeCheck = 0;

            input[i]="repeatthree";
        }
        if (input[i] == "repeatthreeboil") {
            input1.setImageResource(R.drawable.p6repeat3);
            show.setVisibility(View.INVISIBLE);
            boil.setImageResource(R.drawable.boil);
            boilCheck = 0;

            input[i]="repeatthree";
        }
        if (input[i] == "repeatfivemakesok") {
            input1.setImageResource(R.drawable.p6repeat5);
            show.setVisibility(View.INVISIBLE);
            makesok.setImageResource(R.drawable.makesok);
            makesokCheck = 0;

            input[i]="repeatfive";
        }
        if (input[i] == "repeatfivemakepee") {
            input1.setImageResource(R.drawable.p6repeat5);
            show.setVisibility(View.INVISIBLE);
            makepee.setImageResource(R.drawable.makepee);
            makepeeCheck = 0;

            input[i]="repeatfive";
        }
        if (input[i] == "repeatfiveputsok") {
            input1.setImageResource(R.drawable.p6repeat5);
            show.setVisibility(View.INVISIBLE);
            putsok.setImageResource(R.drawable.putsok);
            putsokCheck = 0;

            input[i]="repeatfive";
        }
        if (input[i] == "repeatfivemakeshape") {
            input1.setImageResource(R.drawable.p6repeat5);
            show.setVisibility(View.INVISIBLE);
            makeshape.setImageResource(R.drawable.makeshape);
            makeshapeCheck = 0;

            input[i]="repeatfive";
        }
        if (input[i] == "repeatfiveboil") {
            input1.setImageResource(R.drawable.p6repeat5);
            show.setVisibility(View.INVISIBLE);
            boil.setImageResource(R.drawable.boil);
            boilCheck = 0;

            input[i]="repeatfive";
        }
        if (input[i] == "repeattenmakesok") {
            input1.setImageResource(R.drawable.p6repeat10);
            show.setVisibility(View.INVISIBLE);
            makesok.setImageResource(R.drawable.makesok);
            makesokCheck = 0;

            input[i]="repeatten";
        }
        if (input[i] == "repeattenmakepee") {
            input1.setImageResource(R.drawable.p6repeat10);
            show.setVisibility(View.INVISIBLE);
            makepee.setImageResource(R.drawable.makepee);
            makepeeCheck = 0;

            input[i]="repeatten";
        }
        if (input[i] == "repeattenputsok") {
            input1.setImageResource(R.drawable.p6repeat10);
            show.setVisibility(View.INVISIBLE);
            putsok.setImageResource(R.drawable.putsok);
            putsokCheck = 0;

            input[i]="repeatten";
        }
        if (input[i] == "repeattenmakeshape") {
            input1.setImageResource(R.drawable.p6repeat10);
            show.setVisibility(View.INVISIBLE);
            makeshape.setImageResource(R.drawable.makeshape);
            makeshapeCheck = 0;

            input[i]="repeatten";
        }
        if (input[i] == "repeattenboil") {
            input1.setImageResource(R.drawable.p6repeat10);
            show.setVisibility(View.INVISIBLE);
            boil.setImageResource(R.drawable.boil);
            boilCheck = 0;

            input[i]="repeatten";
        }
    }
    // 위의 함수들은 onClicked에서 반복되는 부분들을 묶은것들이다

    public void onClicked(View args){ //버튼 눌렀을때
        ImageView input1 = (ImageView)findViewById(R.id.input1);
        ImageView input2 = (ImageView)findViewById(R.id.input2);
        ImageView input3 = (ImageView)findViewById(R.id.input3);
        ImageView input4 = (ImageView)findViewById(R.id.input4);
        ImageView input5 = (ImageView)findViewById(R.id.input5);
        ImageView show = (ImageView)findViewById(R.id.show);

        count++;
        clicksound.play(soundId2,1f,1f,0,0,1f);
        if(count==1){ //첫번째 누름
            noRepeat(0,args,input1,input2,show);
            if (((ImageButton) args).getId() == R.id.back) {
                input1.setImageResource(R.drawable.quest);
                count=0;
            }
        }
        else if(count==2){ //두번째 누름
            if(repeatCheck[0]==0){ //반복문 없었으면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(0, args, input1, input2, show);
                    count=0;}
                noRepeat(1,args,input2,input3,show);
            }
            else if(repeatCheck[0]>0){ //첫번째가 반복문이면 -> 시간선택
                if (((ImageButton) args).getId() == R.id.back) {
                repeatBack(0,args,input1,show);
                count=0;}
                getMinutes(0, args, input1);
            }
        }
        else if(count==3){ //세번째 누름
            if(repeatCheck[1]==0&&repeatCheck[0]==0){ //반복문 없었으면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(1, args, input2, input3, show);
                count=1;}
                noRepeat(2,args,input3,input4,show);
            }
            if(repeatCheck[0]>0) {//첫번째 반복문이면 -> 행동 받기
                if (((ImageButton) args).getId() == R.id.back) { //시간지우기
                    getMinutesBack(0, args, input1, show);
                count=1;}
                nMinutesRepeat(0, args, input1,input2,show);
            }
            if(repeatCheck[1]>0) {//두번째가 반복문이면 -> 시간받기
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(1, args, input2, show);
                count=1;}
                getMinutes(1, args, input2);
            }
        }
        else if(count==4){ //네번째 누름
            if(repeatCheck[2]==0&&repeatCheck[1]==0&&repeatCheck[0]==0){ // 반복문 없었으면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(2, args, input3, input4, show);
                count=2;}
                noRepeat(3,args,input4,input5,show);
            }
            else if(repeatCheck[0]>0){ //첫번째가 반복문이면
                if (((ImageButton) args).getId() == R.id.back) {
                    nMinutesRepeatBack(0, args, input1, input2, show);
                count=2;}//행동지우기
                noRepeat(1,args,input2,input3,show);
            }
            else if(repeatCheck[1]>0) { //두번째가 반복분이면 -> 행동받기
                if (((ImageButton) args).getId() == R.id.back) {
                    getMinutesBack(1, args, input2, show);
                count=2;}
                nMinutesRepeat(1, args, input2,input3,show);
            }
            else if(repeatCheck[2]>0){ //세번째가 반복문이면 -> 시간받기
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(2, args, input3, show);
                count=2;}
                getMinutes(2,args,input3);
            }
        }
        else if(count==5){ //다섯번째 누름
            if(repeatCheck[3]==0&&repeatCheck[2]==0&&repeatCheck[1]==0&&repeatCheck[0]==0){ //반복문 없었으면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(3, args, input4, input5, show);
                count=3;}
                noRepeatLast(4,args,input5,show);
            }
            else if(repeatCheck[0]>0){ //첫번째나 반복문이면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(1, args, input2, input3, show);
                count=3;}
                noRepeat(2,args,input3,input4,show);
            }
            else if(repeatCheck[1]>0){ //두번째가 반복문이면 ->행동삭제
                if (((ImageButton) args).getId() == R.id.back) {
                    nMinutesRepeatBack(1, args, input2, input3, show);
                count=3;}
                noRepeat(2,args,input3,input4,show);
            }
            else if(repeatCheck[2]>0) {//세번째 시간 받았으면 -> 반복할 행동 받기
                if (((ImageButton) args).getId() == R.id.back) {
                    getMinutesBack(2, args, input3, show);
                count=3;}
                nMinutesRepeat(2, args, input3,input4,show);
            }
            if(repeatCheck[3]>0){//네번째가 반복문이면 -> 시간받기
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(3, args, input4, show);
                count=3;}
                getMinutes(3,args,input4);
            }
        }
        else if(count==6){ //여섯번째 누름
            if(repeatCheck[4]==0&&repeatCheck[3]==0&&repeatCheck[2]==0&&repeatCheck[1]==0&&repeatCheck[0]==0){ // 반복문 없었으면
            //    Toast.makeText(this, "완성 버튼 누르세요", Toast.LENGTH_SHORT).show();
                count=5;
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(4,args,input5,show);
                    count=4;
                }
            }
            else if(repeatCheck[4]>0){//다섯번째가 반복문이면 -> 시간받기
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(4, args, input5, show);
                count=4;}
                getMinutes(4,args,input5);
            }
            else if(repeatCheck[3]>0) {//네번째가 반복문이면 -> 반복할 행동 받기
                if (((ImageButton) args).getId() == R.id.back) {
                    getMinutesBack(3, args, input4, show);
                count=4;}
                nMinutesRepeat(3, args, input4,input5,show);
            }
            else if(repeatCheck[1]>0||repeatCheck[0]>0){ //두번째,첫번째 중 한개 가 반복문이면
                if (((ImageButton) args).getId() == R.id.back) {
                    noRepeatBack(2, args, input3, input4, show);
                count=4;}
                noRepeat(3,args,input4,input5,show);
            }
            else if(repeatCheck[2]>0){ //세번째가 반복문이면 -> 행동지우기
                if (((ImageButton) args).getId() == R.id.back) {
                nMinutesRepeatBack(2,args,input3,input4,show);
                count=4;}
                noRepeat(3,args,input4,input5,show);
            }
        }
        else if(count==7){ //일곱번째 누름
            if(repeatCheck[4]==0&&repeatCheck[3]==0&&repeatCheck[2]==0&&repeatCheck[1]==0&&repeatCheck[0]==0){ // 반복문 없었으면
               // Toast.makeText(this, "완성 버튼 누르세요", Toast.LENGTH_SHORT).show();
                count=6;
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(4,args,input5,show);
                    count=5;
                }
            }
            else if(repeatCheck[4]>0) {//다섯번째 반복문이면 -> 행동받기
                if (((ImageButton) args).getId() == R.id.back) {
                getMinutesBack(4,args,input5,show);
                count=5;}
                nMinutesRepeatLast(4, args, input5,show);
            }
            else if(repeatCheck[2]>0||repeatCheck[1]>0||repeatCheck[0]>0){ //세번째,두번째,첫번째 중 한개 반복문이면
                if (((ImageButton) args).getId() == R.id.back) {
                noRepeatBack(3,args,input4,input5,show);
                count=5;}
                noRepeatLast(4,args,input5,show);
            }
            else if(repeatCheck[3]>0) { //네번째가 반복문이면 -> 행동 지우기
                if (((ImageButton) args).getId() == R.id.back) {
                nMinutesRepeatBack(3,args,input4,input5,show);
                count=5;}
                noRepeatLast(4,args,input5,show);
            }
        }

        else if(count>=8){ //여덟번째누름
            if(repeatCheck[4]>0) {//다섯번째 반복문이면 -> 행동지우기
                if (((ImageButton) args).getId() == R.id.back) {
                    nMinutesRepeatLastBack(4,args,input5,show);
                    count=6;}
            }
            if(repeatCheck[4]==0){ //다섯번째가 반복문 아니면 ->그냥 지우기
                if (((ImageButton) args).getId() == R.id.back) {
                    repeatBack(4,args,input5,show);
                    count=6;}
            }
            if(((ImageButton) args).getId() != R.id.back) {
                Toast.makeText(this, "완성 버튼 누르세요", Toast.LENGTH_SHORT).show();
                count=7;
            }
        }

    }
    Button.OnClickListener mClickListener = new View.OnClickListener(){
        public void onClick(View v) { //완성버튼 클릭

            clicksound.play(soundId2,1f,1f,0,0,1f);
            completeCheck=1;
            for(int i=2;i<5;i++){
                if(input[i]==answer[i]){
                    answerCheck++;
                }else answerCheck=0;
            }
            for(int i=0;i<2;i++){
                if(input[i]=="makesok"||input[i]=="makepee"){
                    answerCheck2++;
                }else answerCheck2=0;
            }
            if(answerCheck==3&&answerCheck2==2 ){ //성공
                Intent intent = new Intent(mandu.this, mandu_clear.class);
                startActivity(intent);
                finish();
            }
            else { //실패
                Intent intent = new Intent(mandu.this, mandu_fail.class);
                startActivity(intent);
                finish();
            }
        }
    };

    }




