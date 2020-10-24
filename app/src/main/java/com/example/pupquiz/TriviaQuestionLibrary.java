package com.example.pupquiz;

public class TriviaQuestionLibrary {
    private String triviaQuestionsLabel[]={
            "Question 1",
            "Question 2",
            "Question 3",
            "Question 4",
            "Question 5",
            "Question 6",
            "Question 7",
            "Question 8",
            "Question 9",
            "Question 10"
    };
    private String triviaQuestions[] ={
            "Normal adult dogs have how many teeth?",
            "Through what part of the body do dogs sweat?",
            "What is the most common training command taught to dogs?",
            "What is a dog’s most highly developed sense?",
            "Puppies are delivered how many weeks after conception?",
            "What is the favorite dog breed of the Queen of England, Elizabeth II?",
            "Which dog breed is the smallest of them all?",
            "Which dog breed’s coat has a texture that’s similar to human hair?",
            "Which TV series had a dog named K9 who was also a robot?",
            "How old was the verified world’s oldest dog (an Australian Cattle Hound) when he died?"
    };

    private String triviaChoices[][] = {
            {"24","16","42"},
            {"Paws","Armpit","Ears"},
            {"Stay","Sit","Beg"},
            {"Taste","Smell","Sight"},
            {"20","14","9"},
            {"Pomeranian","Rottweiler","Corgi"},
            {"Chihuahua","Shih Tzu","Dachshund"},
            {"Poodle","Yorkshire Terrier","Shih Tzu"},
            {"Star Trek","Mr.Robot","Doctor Who"},
            {"20","14","29"},
    };

    private String triviaAnswers[]={
            "42",
            "Paws",
            "Sit",
            "Smell",
            "9",
            "Corgi",
            "Chihuahua",
            "Yorkshire Terrier",
            "Doctor Who",
            "29",

    };

    public String getQuestionLabel(int a){
        String questionLabel = triviaQuestionsLabel[a];
        return questionLabel;
    }
    public String getQuestion(int a){
        String question = triviaQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = triviaChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = triviaChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a){
        String choice2 = triviaChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = triviaAnswers[a];
        return answer;
    }
}
