package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class InstructionsTrivia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_trivia);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.intro.start();
    }

    public void backBtnClick (View view){
        Intent intent = new Intent(this, TypeOfQuizPage.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(this);
        MainActivity.intro.pause();
    }

    public void onClickStartTrivia (View view){
        Intent intent = new Intent(this, QuizPageTrivia.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
        MainActivity.intro.pause();
        MainActivity.buttonClick.start();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
        MainActivity.intro.pause();
    }
}