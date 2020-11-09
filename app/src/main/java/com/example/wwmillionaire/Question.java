package com.example.wwmillionaire;


public class Question {
    private String question;
    private String[] choice = new String[10];
    private String answer;

    public Question() {

    }

    public Question(String question, String[] choices, String answer) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.choice[4] = choices[4];
        this.choice[5] = choices[5];
        this.choice[6] = choices[6];
        this.choice[7] = choices[7];
        this.choice[8] = choices[8];
        this.choice[9] = choices[9];
        this.choice[10] = choices[10];
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice(int i) {
        return choice[i];
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setChoice(int i, String choice) {
        this.choice[i] = choice;
    }

    public void setQuestion(String question) {
        this.question = question;


    }
}