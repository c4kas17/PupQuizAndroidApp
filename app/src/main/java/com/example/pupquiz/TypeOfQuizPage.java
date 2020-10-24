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

    public void onClickBreed (View view){
        Intent intent = new Intent(this, InstructionsGuessTheBreed.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }
    public void onClickTrivia (View view){
        Intent intent = new Intent(this, InstructionsTrivia.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }

}