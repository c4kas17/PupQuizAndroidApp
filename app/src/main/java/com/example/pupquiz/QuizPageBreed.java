package com.example.pupquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class QuizPageBreed extends AppCompatActivity implements View.OnClickListener {
    String val1, val2;
    public static Button next;
    public static int final_score = 0;
    public static int final_score_prc = 0;
    Fragment fragment;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_breed);
        fragment = new Question1FragmentBreed();
        transit(fragment);
        next = findViewById(R.id.nextBreedBtn);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        count++;
        if (count == 2) {
            fragment = new Question2FragmentBreed();
            transit(fragment);
            final_score += Question1FragmentBreed.score;
            final_score_prc += Question1FragmentBreed.scorePerc;
        } else if (count == 3) {
            fragment = new Question3FragmentBreed();
            transit(fragment);
            final_score += Question2FragmentBreed.score;
            final_score_prc += Question2FragmentBreed.scorePerc;
        } else if (count == 4) {
            fragment = new Question4FragmentBreed();
            transit(fragment);
            final_score += Question3FragmentBreed.score;
            final_score_prc += Question3FragmentBreed.scorePerc;
        } else if (count == 5) {
            fragment = new Question5FragmentBreed();
            transit(fragment);
            final_score += Question4FragmentBreed.score;
            final_score_prc += Question4FragmentBreed.scorePerc;
        } else if (count == 6) {
            fragment = new Question6FragmentBreed();
            transit(fragment);
            final_score += Question5FragmentBreed.score;
            final_score_prc += Question5FragmentBreed.scorePerc;
        } else if (count == 7) {
            fragment = new Question7FragmentBreed();
            transit(fragment);
            final_score += Question6FragmentBreed.score;
            final_score_prc += Question6FragmentBreed.scorePerc;
        } else if (count == 8) {
            fragment = new Question8FragmentBreed();
            transit(fragment);
            final_score += Question7FragmentBreed.score;
            final_score_prc += Question7FragmentBreed.scorePerc;
        } else if (count == 9) {
            fragment = new Question9FragmentBreed();
            transit(fragment);
            final_score += Question8FragmentBreed.score;
            final_score_prc += Question8FragmentBreed.scorePerc;
        } else if (count == 10) {
            fragment = new Question10FragmentBreed();
            transit(fragment);
            final_score += Question9FragmentBreed.score;
            final_score_prc += Question9FragmentBreed.scorePerc;
            transform(next);
        } else if (count == 11) {

            final_score += Question10FragmentBreed.score;
            final_score_prc += Question10FragmentBreed.scorePerc;
            submit(next);
            final_score_prc = 0;
            final_score = 0;
        }


    }

    public void transform (View view){
        next.setBackgroundResource(R.drawable.submit_bg);
        next.setHeight(100);
        next.setWidth(0);
        next.setText("Submit");
        next.setTextSize(20);
    }

    public void submit (View view){
        String val1 = String.valueOf(final_score_prc);
        String val2 = String.valueOf(final_score);
        Intent intent = new Intent(this, ScorePage.class);
        intent.putExtra("FINAL_SCORE_PERCENT", val1);
        intent.putExtra("FINAL_SCORE",val2);
        startActivity(intent);
        Animatoo.animateSpin(this);


    }

    void transit(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.animate_fade_enter, R.anim.animate_fade_exit);
        transaction.replace(R.id.tframelayoutid, fragment);
        transaction.commit();
    }
}



