package com.example.yukakosunabe.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.yukakosunabe.quizapp.DataStoreModel.HtmlScore;
import com.example.yukakosunabe.quizapp.QuizLibrary.HtmlCssQuizLiblary;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    private TextView htmlHighScore;
    private TextView jsHighScore;
    private TextView javaHighScore;

    private HtmlCssQuizActivity mHtmlCssQuizActivity = new HtmlCssQuizActivity();
    private HtmlCssQuizLiblary mHtmlCssQuizLiblary = new HtmlCssQuizLiblary();
    private JsQuizActivity mJsQuizActivity = new JsQuizActivity();
    private JavaQuizActivity mJavaQuizActivity = new JavaQuizActivity();

    private int highScore;
    private int lastScore;

    private DatabaseReference ref_html;
    private ArrayList<HtmlScore> scores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        htmlHighScore = findViewById(R.id.html_high_score);
        jsHighScore = findViewById(R.id.javascript_high_score);
        javaHighScore = findViewById(R.id.java_high_score);
        scores = new ArrayList<>();


        FirebaseDatabase database = FirebaseDatabase.getInstance(); // Connect to database
        ref_html = database.getReference("HTML"); // inside the databse, find reference of "message"

        ref_html.child("-LIMsAGSW4gXbC7CMJX-").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                htmlHighScore.setText(dataSnapshot.child("score").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
