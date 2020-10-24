package com.example.pupquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Question8FragmentTrivia extends Fragment {
    private TriviaQuestionLibrary myTriviaQuestionLibrary = new TriviaQuestionLibrary();

    private Button btn1, btn2, btn3, tBackBtn;
    private TextView questionLabelTextView;
    private TextView questionTextView;
    private String ans;
    private int mQuestionNumber =7;
    public static int tscorePerc;
    public static int tscore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question1_trivia, container, false);
        perform(view);
        updateQuestion();
        return view;
    }

    public void perform(View view){
        tBackBtn= view.findViewById(R.id.nextTriviaBtn);
        btn1 = view.findViewById(R.id.choice1TriviaBtn1);
        btn2 = view.findViewById(R.id.choice2TriviaBtn1);
        btn3 = view.findViewById(R.id.choice3TriviaBtn1);
        questionLabelTextView = view.findViewById(R.id.questionLabel1);
        questionTextView = view.findViewById(R.id.question1TxtView);
        QuizPageTrivia.fnext.setVisibility(View.INVISIBLE);
        QuizPageTrivia.fnext.setEnabled(false);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setSelected(!btn1.isSelected());

                QuizPageTrivia.fnext.setVisibility(View.VISIBLE);
                QuizPageTrivia.fnext.setEnabled(true);

                if(btn1.isSelected()){

                    if(btn1.getText().toString().equals(ans)){
                        tscorePerc = 10;
                        tscore = 1;
                        btn1.setBackgroundResource(R.color.rightAns);
                        btn1.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                        }
                    else{
                        tscorePerc = 0;
                        tscore = 0;
                        btn1.setBackgroundResource(R.color.wrongAns);
                        btn1.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }

                    btn2.setEnabled(false);
                    btn3.setEnabled(false);

                }
                }

        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setSelected(!btn2.isSelected());

                QuizPageTrivia.fnext.setVisibility(View.VISIBLE);
                QuizPageTrivia.fnext.setEnabled(true);

                if(btn2.isSelected()){

                    if(btn2.getText().toString().equals(ans)){
                        tscorePerc = 10;
                        tscore = 1;
                        btn2.setBackgroundResource(R.color.rightAns);
                        btn2.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        tscorePerc = 0;
                        tscore = 0;
                        btn2.setBackgroundResource(R.color.wrongAns);
                        btn2.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn1.setEnabled(false);
                    btn3.setEnabled(false);

                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setSelected(!btn3.isSelected());

                QuizPageTrivia.fnext.setVisibility(View.VISIBLE);
                QuizPageTrivia.fnext.setEnabled(true);

                if(btn3.isSelected()){

                    if(btn3.getText().toString().equals(ans)){
                        tscorePerc = 10;
                        tscore = 1;
                        btn3.setBackgroundResource(R.color.rightAns);
                        btn3.setEnabled(false);
                        Fragment fragmentCorrect = new CorrectFragment();
                        transit(fragmentCorrect);
                    }
                    else{
                        tscorePerc = 0;
                        tscore = 0;
                        btn3.setBackgroundResource(R.color.wrongAns);
                        btn3.setEnabled(false);
                        Fragment fragmentWrong = new WrongFragment();
                        transit(fragmentWrong);
                    }
                    btn2.setEnabled(false);
                    btn1.setEnabled(false);
                }
            }
        });
    }
    private void updateQuestion () {
        questionLabelTextView.setText((myTriviaQuestionLibrary.getQuestionLabel(mQuestionNumber)));
        questionTextView.setText(myTriviaQuestionLibrary.getQuestion(mQuestionNumber));
        btn1.setText(myTriviaQuestionLibrary.getChoice1(mQuestionNumber));
        btn2.setText(myTriviaQuestionLibrary.getChoice2(mQuestionNumber));
        btn3.setText(myTriviaQuestionLibrary.getChoice3(mQuestionNumber));
        ans = myTriviaQuestionLibrary.getCorrectAnswer(mQuestionNumber);
    }
    void transit(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setCustomAnimations(R.anim.animate_fade_enter, R.anim.animate_fade_exit);
        transaction.replace(R.id.statusLayout, fragment);
        transaction.commit();
    }
}