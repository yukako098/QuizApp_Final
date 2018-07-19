package com.example.yukakosunabe.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowScore extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        Intent intent = this.getIntent();
        String score = intent.getStringExtra("sendScore");
        TextView score_text = findViewById(R.id.socre_tv);
        score_text.setText(score);


    }

    public void topBtnClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("html&css", "yep"); // "id" -> "data"

        // start an Activity
        startActivity(intent);
    }

    public void tryAgainBtnClicked(View view) {
        Intent intent = new Intent(this, HtmlCssQuizActivity.class);
        intent.putExtra("html&css", "yep"); // "id" -> "data"

        // start an Activity
        startActivity(intent);
    }
}
