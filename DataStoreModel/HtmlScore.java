package com.example.yukakosunabe.quizapp.DataStoreModel;

public class HtmlScore {

    private String user_id;
    private int score;

    public HtmlScore() {
    }

    public HtmlScore(String user_id, int score) {
        this.user_id = user_id;
        this.score = score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(this.score);
    }
}
