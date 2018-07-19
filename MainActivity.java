package com.example.yukakosunabe.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void playBtnClicked(View view) {
        Intent intent = new Intent(this, ChooseLangActivity.class);

        // start an Activity
        startActivity(intent);
    }


    public void historyBtnClicked(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);

        startActivity(intent);
    }
}
