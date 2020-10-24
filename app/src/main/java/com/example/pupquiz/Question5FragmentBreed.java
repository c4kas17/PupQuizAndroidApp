package com.example.pupquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Question5FragmentBreed extends Fragment {
    Button btn1, btn2, btn3, btn4;
    String ans = "Corgi";
    public static int scorePerc;
    public static int score;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question5_breed, container, false);
        perform(view);
        QuizPageBreed.next.setEnabled(false);
        QuizPageBreed.next.setVisibility(View.INVISIBLE);
        return view;
    }

    public void perform(View view){
        btn1 = view.findViewById(R.id.choice1BreedBtn5);
        btn2 = view.findViewById(R.id.choice2BreedBtn5);
        btn3 = view.findViewById(R.id.choice3BreedBtn5);
        btn4 = view.findViewById(R.id.choice4BreedBtn5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setSelected(!btn1.isSelected());
                QuizPageBreed.next.setVisibility(View.VISIBLE);
                QuizPageBreed.next.setEnabled(true);
                if(btn1.isSelected()){
                    if(btn1.getText().toString().equals(ans)){
                        scorePerc = 10;
                        score = 1;
                        btn1.setBackgroundResource(R.color.rightAns);
                        btn1.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        scorePerc = 0;
                        score = 0;
                        btn1.setBackgroundResource(R.color.wrongAns);
                        btn1.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setSelected(!btn2.isSelected());
                QuizPageBreed.next.setVisibility(View.VISIBLE);
                QuizPageBreed.next.setEnabled(true);
                if(btn2.isSelected()){
                    if(btn2.getText().toString().equals(ans)){
                        scorePerc = 10;
                        score = 1;
                        btn2.setBackgroundResource(R.color.rightAns);
                        btn2.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        scorePerc = 0;
                        score = 0;
                        btn2.setBackgroundResource(R.color.wrongAns);
                        btn2.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn1.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setSelected(!btn3.isSelected());
                QuizPageBreed.next.setVisibility(View.VISIBLE);
                QuizPageBreed.next.setEnabled(true);
                if(btn3.isSelected()){
                    if(btn3.getText().toString().equals(ans)){
                        scorePerc = 10;
                        score = 1;
                        btn3.setBackgroundResource(R.color.rightAns);
                        btn3.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        scorePerc = 0;
                        score = 0;
                        btn3.setBackgroundResource(R.color.wrongAns);
                        btn3.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn4.setEnabled(false);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setSelected(!btn4.isSelected());
                QuizPageBreed.next.setVisibility(View.VISIBLE);
                QuizPageBreed.next.setEnabled(true);
                if(btn4.isSelected()){
                    if(btn4.getText().toString().equals(ans)){
                        scorePerc = 10;
                        score = 1;
                        btn4.setBackgroundResource(R.color.rightAns);
                        btn4.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        scorePerc = 0;
                        score = 0;
                        btn4.setBackgroundResource(R.color.wrongAns);
                        btn4.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                }
            }
        });
    }
    void transit(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.animate_fade_enter, R.anim.animate_fade_exit);
        transaction.replace(R.id.statusLayout, fragment);
        transaction.commit();
    }
}