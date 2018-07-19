package com.example.yukakosunabe.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HtmlCssQuizActivity extends AppCompatActivity {

    private HtmlCssQuizLiblary mHtmlCssQuizLiblary = new HtmlCssQuizLiblary();

    private TextView mQuestionNumber;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mBtnChoice1;
    private Button mBtnChoice2;
    private Button mBtnChoice3;
    private Button mBtnChoice4;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        mQuestionNumber = findViewById(R.id.questionNum_tv);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question_tv);
        mBtnChoice1 = findViewById(R.id.choice1);
        mBtnChoice2 = findViewById(R.id.choice2);
        mBtnChoice3 = findViewById(R.id.choice3);
        mBtnChoice4 = findViewById(R.id.choice4);

        updateQuestion();


        // Start Btn1'Listener
        mBtnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    updateQuestionNum(mQuestionNum);
                    toast("Correct!");
                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);
                    toast("Wrong!");
                    updateQuestion();
                    updateQuestionNum(mQuestionNum);
                }
            }
        });
        // End Btn1's Listener

        // Start Btn2'Listener
        mBtnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    updateQuestionNum(mQuestionNum);

                    toast("Correct!");
                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);
                    updateQuestionNum(mQuestionNum);
                    toast("Wrong!");
                    updateQuestion();
                }
            }
        });
        // End Btn2's Listener

        // Start Btn3'Listener
        mBtnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    updateQuestionNum(mQuestionNum);

                    toast("Correct!");
                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);
                    updateQuestionNum(mQuestionNum);
                    toast("Wrong!");
                    updateQuestion();
                }
            }
        });
        // End Btn3's Listener

        // Start Btn4'Listener
        mBtnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice4.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    updateQuestionNum(mQuestionNum);

                    toast("Correct!");
                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);
                    updateQuestionNum(mQuestionNum);
                    toast("Wrong!");
                    updateQuestion();
                }
            }
        });
        // End Btn4's Listener

    }

    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    private void updateQuestion() {

        if (mQuestionNum < mHtmlCssQuizLiblary.getmQuestion().length) {
            mQuestionView.setText(mHtmlCssQuizLiblary.getQuestion(mQuestionNum));
            mBtnChoice1.setText(mHtmlCssQuizLiblary.getChoice1(mQuestionNum));
            mBtnChoice2.setText(mHtmlCssQuizLiblary.getChoice2(mQuestionNum));
            mBtnChoice3.setText(mHtmlCssQuizLiblary.getChoice3(mQuestionNum));
            mBtnChoice4.setText(mHtmlCssQuizLiblary.getChoice4(mQuestionNum));

            mAnswer = mHtmlCssQuizLiblary.getCorrectAnswer(mQuestionNum);
            mQuestionNum++;
        } else {
            Intent intent = new Intent(this, ShowScore.class);
            intent.putExtra("sendScore", mScoreView.getText().toString());
            startActivity(intent);

        }

    }

    private void updateScore(int point){
        mScoreView.setText("Your Score " + mScore);
    }
    private void updateQuestionNum(int num){
        mQuestionNumber.setText("Question No." + mQuestionNum );
    }

}
