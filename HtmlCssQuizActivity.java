package com.example.yukakosunabe.quizapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yukakosunabe.quizapp.DataStoreModel.HtmlScore;
import com.example.yukakosunabe.quizapp.QuizLibrary.HtmlCssQuizLiblary;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

@TargetApi(Build.VERSION_CODES.N)
@RequiresApi(api = Build.VERSION_CODES.N)
public class HtmlCssQuizActivity extends AppCompatActivity {

    private HtmlCssQuizLiblary mHtmlCssQuizLiblary = new HtmlCssQuizLiblary();
    private HtmlScore mHtmlScore;

    private TextView questionNumTV;
    private TextView countDown;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mBtnChoice1;
    private Button mBtnChoice2;
    private Button mBtnChoice3;
    private Button mBtnChoice4;

    private String mAnswer;
    private int totalQuestionNum;
    private int mQuestionNum;
    private int mScore;

    // [START declare_database_ref]
    private DatabaseReference ref_html;
    // [END declare_database_ref]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        totalQuestionNum = mHtmlCssQuizLiblary.getmQuestion().length;
        questionNumTV = findViewById(R.id.questionNum_tv);
        countDown = findViewById(R.id.countdown);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question_tv);
        mBtnChoice1 = findViewById(R.id.choice1);
        mBtnChoice2 = findViewById(R.id.choice2);
        mBtnChoice3 = findViewById(R.id.choice3);
        mBtnChoice4 = findViewById(R.id.choice4);


        countdown();
        updateQuestion();

        // Start Btn1'Listener
        mBtnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBtnChoice1.getText() == mAnswer){
                    mScore++;
                    toast("Correct!");
                } else {
                    mScore--;
                    toast("Wrong!");
                }
                updateQuestion();
                updateQuestionNum(mQuestionNum);
                updateScore(mScore);
            }
        });
        // End Btn1's Listener

        // Start Btn2'Listener
        mBtnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBtnChoice2.getText() == mAnswer){
                    mScore++;
                    toast("Correct!");
                } else {
                    mScore--;
                    toast("Wrong!");
                }
                updateScore(mScore);
                updateQuestion();
                updateQuestionNum(mQuestionNum);

            }
        });
        // End Btn2's Listener

        // Start Btn3'Listener
        mBtnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice3.getText() == mAnswer){
                    mScore++;
                    toast("Correct!");
                } else {
                    mScore--;
                    toast("Wrong!");
                }
                updateScore(mScore);
                updateQuestion();
                updateQuestionNum(mQuestionNum);

            }
        });
        // End Btn3's Listener

        // Start Btn4'Listener
        mBtnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBtnChoice4.getText() == mAnswer){
                    mScore++;
                    toast("Correct!");
                } else {
                    mScore--;
                    toast("Wrong!");
                }
                updateScore(mScore);
                updateQuestionNum(mQuestionNum);
                updateQuestion();
            }
        });
        // End Btn4's Listener

    }

    private void countdown() {
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDown.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (mQuestionNum != totalQuestionNum){

                    intent();
                } else {

                }
            }
        }.start();
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
            intent();
        }

    }

    private void updateQuestionNum(int num){
        questionNumTV.setText("Q" + num );
    }

    private void intent() {
        FirebaseDatabase database = FirebaseDatabase.getInstance(); // Connect to database
        ref_html = database.getReference("HTML"); // inside the databse, find reference of "message"
        String unique_id = ref_html.push().getKey();

        mHtmlScore = new HtmlScore(unique_id, 100 / totalQuestionNum * mScore);

        ref_html.child(unique_id).setValue(mHtmlScore);

        Intent intent = new Intent(this, ShowScore.class);
        intent.putExtra("sendScore", mScoreView.getText().toString());
        intent.putExtra("user_id", mHtmlScore.getUser_id());
        intent.putExtra("html_score", mHtmlScore.getScore());

        startActivity(intent);
    }

    public void updateScore(int point){
        // TODO every point should storage in database whether it's best score or not.
        point = 100 / totalQuestionNum * mScore;
        mScoreView.setText("Score " + point);

        // TODO compared to high score, if last score is higher than high score, last score gonna be high score.

    }

}
