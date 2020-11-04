package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class ScorePage extends AppCompatActivity {
    TextView score_prc_txtView;
    TextView score_txtView;
    String final_score_prc;
    String final_score;
    MediaPlayer rightMusic, wrongMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        Intent intent = getIntent();
        final_score_prc = intent.getStringExtra("FINAL_SCORE_PERCENT");
        final_score = intent.getStringExtra("FINAL_SCORE");

        String displayPercent = final_score_prc + "%";
        String displayScoreText = "You answered "+ final_score + "/10 questions correctly..";
        score_prc_txtView = (TextView) findViewById(R.id.scoreLabelPerc);
        score_prc_txtView.setText(displayPercent);

        score_txtView  = (TextView) findViewById(R.id.scoreLabelText);
        score_txtView.setText(displayScoreText);
        if(getInt(final_score)>5){
            rightMusic = MediaPlayer.create(this,R.raw.yehey);
            rightMusic.start();
        }
        else if(getInt(final_score)<5){
            wrongMusic = MediaPlayer.create(this,R.raw.fail);
            wrongMusic.start();
        }


    }

    public void onNewQuizClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateZoom(this);
        if(getInt(final_score)>5){
            rightMusic.release();
        }
        else if(getInt(final_score)<5) {
            wrongMusic.release();
        }
        MainActivity.buttonClick.start();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }
    public int getInt(String s){
        return Integer.parseInt(s.replaceAll("[\\D]", ""));
    }
}