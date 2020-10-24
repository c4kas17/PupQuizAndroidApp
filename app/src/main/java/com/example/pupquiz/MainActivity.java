package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intro = MediaPlayer.create(this,R.raw.intromusic);
        intro.start();
    }

    public void onClick (View view){
        Intent intent = new Intent(this, TypeOfQuizPage.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
        intro.release();
    }
}