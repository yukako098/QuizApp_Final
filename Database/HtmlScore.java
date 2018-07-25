package com.example.yukakosunabe.quizapp.Database;

public class HtmlScore {

    private String user_id;
    private String score;

    public HtmlScore() {
    }

    public HtmlScore(String user_id, String score) {
        this.user_id = user_id;
        this.score = score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.score ;
    }
}
