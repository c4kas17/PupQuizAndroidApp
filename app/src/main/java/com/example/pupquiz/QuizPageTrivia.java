package com.example.pupquiz;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.w3c.dom.Text;

public class QuizPageTrivia extends AppCompatActivity implements View.OnClickListener {
    private TriviaQuestionLibrary myTriviaQuestionLibrary = new TriviaQuestionLibrary();

    String val1, val2;
    public static Button fnext;
    public static int tfinal_score = 0;
    public static int tfinal_score_prc = 0;
    Fragment fragment;
    int count = 1;
    MediaPlayer player;
    MediaPlayer buttonMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_trivia);
        fragment = new Question1FragmentTrivia();
        transit(fragment);

        fnext = findViewById(R.id.nextTriviaBtn);
        fnext.setOnClickListener(this);
        player = MediaPlayer.create(this,R.raw.bgmusic);
        player.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
        player.start();
    }
    @Override
        public void onClick (View v){
        buttonMusic = MediaPlayer.create(this,R.raw.nextbgmusic);
        buttonMusic.start();
            count++;
            if (count == 2) {
                fragment = new Question2FragmentTrivia();
                transit(fragment);
                tfinal_score += Question1FragmentTrivia.tscore;
                tfinal_score_prc += Question1FragmentTrivia.tscorePerc;

            }
            else if(count == 3){
                fragment = new Question3FragmentTrivia();
                transit(fragment);
                tfinal_score += Question2FragmentTrivia.tscore;
                tfinal_score_prc += Question2FragmentTrivia.tscorePerc;
            }
            else if(count == 4){
                fragment = new Question4FragmentTrivia();
                transit(fragment);
                tfinal_score += Question3FragmentTrivia.tscore;
                tfinal_score_prc += Question3FragmentTrivia.tscorePerc;
            }
            else if(count == 5){
                fragment = new Question5FragmentTrivia();
                transit(fragment);
                tfinal_score += Question4FragmentTrivia.tscore;
                tfinal_score_prc += Question4FragmentTrivia.tscorePerc;
            }
            else if(count == 6){
                fragment = new Question6FragmentTrivia();
                transit(fragment);
                tfinal_score += Question5FragmentTrivia.tscore;
                tfinal_score_prc += Question5FragmentTrivia.tscorePerc;
            }
            else if(count == 7){
                fragment = new Question7FragmentTrivia();
                transit(fragment);
                tfinal_score += Question6FragmentTrivia.tscore;
                tfinal_score_prc += Question6FragmentTrivia.tscorePerc;
            }
            else if(count == 8){
                fragment = new Question8FragmentTrivia();
                transit(fragment);
                tfinal_score += Question7FragmentTrivia.tscore;
                tfinal_score_prc += Question7FragmentTrivia.tscorePerc;
            }
            else if(count == 9){
                fragment = new Question9FragmentTrivia();
                transit(fragment);
                tfinal_score += Question8FragmentTrivia.tscore;
                tfinal_score_prc += Question8FragmentTrivia.tscorePerc;
            }
            else if(count == 10){
                fragment = new Question10FragmentTrivia();
                transit(fragment);
                transform(fnext);
                tfinal_score += Question9FragmentTrivia.tscore;
                tfinal_score_prc += Question9FragmentTrivia.tscorePerc;
            }
            else if(count == 11){
                tfinal_score += Question10FragmentTrivia.tscore;
                tfinal_score_prc += Question10FragmentTrivia.tscorePerc;
                submit(fnext);
                tfinal_score_prc = 0;
                tfinal_score = 0;
            //    player.release();
            }


        }


    public void transform (View view){
        fnext.setBackgroundResource(R.drawable.submit_bg);
        fnext.setHeight(100);
        fnext.setWidth(0);
        fnext.setText("Submit");
        fnext.setTextSize(20);
    }

    public void submit (View view){
        String val1 = String.valueOf(tfinal_score_prc);
        String val2 = String.valueOf(tfinal_score);
        Intent intent = new Intent(this, ScorePage.class);
        intent.putExtra("FINAL_SCORE_PERCENT", val1);
        intent.putExtra("FINAL_SCORE",val2);
        startActivity(intent);
        Animatoo.animateSplit(this);


    }
    void transit (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.animate_fade_enter, R.anim.animate_fade_exit);
        transaction.replace(R.id.tframelayoutid, fragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
}
