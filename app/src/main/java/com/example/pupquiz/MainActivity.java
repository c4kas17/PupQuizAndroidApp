package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer intro;
    public static MediaPlayer buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intro = MediaPlayer.create(this,R.raw.intromusic);
        intro.setLooping(true);
        buttonClick = MediaPlayer.create(this,R.raw.btnmusic);
        buttonClick.setLooping(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
       intro.start();
    }

    public void onClick (View view){
        Intent intent = new Intent(this, TypeOfQuizPage.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        buttonClick.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        intro.pause();
    }
}