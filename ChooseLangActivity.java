package com.example.yukakosunabe.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lang);
    }

    public void htmlCssBtnClicked(View view) {
        Intent intent = new Intent(this, HtmlCssQuizActivity.class);

        // start an Activity
        startActivity(intent);

    }

    public void jsBtnClicked(View view) {
        Intent intent = new Intent(this, JsQuizActivity.class);

        // start an Activity
        startActivity(intent);

    }

    public void javaBtnClicked(View view) {
        Intent intent = new Intent(this, JavaQuizActivity.class);

        // start an Activity
        startActivity(intent);
    }



}
