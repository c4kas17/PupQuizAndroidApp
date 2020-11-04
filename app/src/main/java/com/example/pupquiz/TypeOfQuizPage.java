package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class TypeOfQuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_quiz_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.intro.start();
    }

    public void gotoBreed (View view){
        Intent intent = new Intent(this, InstructionsGuessTheBreed.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        MainActivity.buttonClick.start();
        MainActivity.intro.start();
    }
    public void gotoTrivia (View view){
        Intent intent = new Intent(this, InstructionsTrivia.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        MainActivity.buttonClick.start();
        MainActivity.intro.start();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }



    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.intro.pause();

    }
}