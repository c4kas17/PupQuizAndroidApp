package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class InstructionsGuessTheBreed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_guess_the_breed);
    }

    public void backBtnClick (View view){
        Intent intent = new Intent(this, TypeOfQuizPage.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(this);
    }

    public void onClickStartBreed (View view){
        Intent intent = new Intent(this, QuizPageBreed.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
    }
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }
}