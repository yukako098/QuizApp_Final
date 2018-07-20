package com.example.yukakosunabe.quizapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yukakosunabe.quizapp.QuizLibrary.JsQuizLibrary;

public class JsQuizActivity extends AppCompatActivity {

    JsQuizLibrary jsQuizLibrary = new JsQuizLibrary();

    private TextView mQuestionNumber;
    private TextView countDown;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mBtnChoice1;
    private Button mBtnChoice2;
    private Button mBtnChoice3;
    private Button mBtnChoice4;

    private String mAnswer;
    private int totalQuestionNum;
    private int mScore = 0;
    private int mQuestionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);


        totalQuestionNum = jsQuizLibrary.getmQuestion().length;
        mQuestionNumber = findViewById(R.id.questionNum_tv);
        countDown = findViewById(R.id.countdown);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question_tv);
        mBtnChoice1 = findViewById(R.id.choice1);
        mBtnChoice2 = findViewById(R.id.choice2);
        mBtnChoice3 = findViewById(R.id.choice3);
        mBtnChoice4 = findViewById(R.id.choice4);


        updateQuestion();
        countdown();


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

    private void countdown() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDown.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                intent();
            }
        }.start();
    }


    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    private void updateQuestion() {

        if (mQuestionNum < jsQuizLibrary.getmQuestion().length) {
            mQuestionView.setText(jsQuizLibrary.getQuestion(mQuestionNum));
            mBtnChoice1.setText(jsQuizLibrary.getChoice1(mQuestionNum));
            mBtnChoice2.setText(jsQuizLibrary.getChoice2(mQuestionNum));
            mBtnChoice3.setText(jsQuizLibrary.getChoice3(mQuestionNum));
            mBtnChoice4.setText(jsQuizLibrary.getChoice4(mQuestionNum));

            mAnswer = jsQuizLibrary.getCorrectAnswer(mQuestionNum);
            mQuestionNum++;
        } else {
            Intent intent = new Intent(this, ShowScore.class);
            intent.putExtra("sendScore", mScoreView.getText().toString());
            startActivity(intent);

        }

    }

    private void intent() {
        Intent intent = new Intent(this, ShowScore.class);
        intent.putExtra("sendScore", mScoreView.getText().toString());
        startActivity(intent);
    }

    private void updateScore(int point){
        mScoreView.setText("Score "  + 100 / totalQuestionNum * mScore);
    }
    private void updateQuestionNum(int num){
        mQuestionNumber.setText("Q" + mQuestionNum );
    }




}
