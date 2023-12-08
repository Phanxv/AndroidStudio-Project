package com.example.twoactivitieschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MSG_TAG);
        TextView song_name_text = findViewById(R.id.article_heading);
        TextView release_date_text = findViewById(R.id.article_subheading);
        TextView lyric = findViewById(R.id.article);
        if(message.equals("kami-sama")){
            song_name_text.setText(R.string.kami_name);
            release_date_text.setText(R.string.kami_release);
            lyric.setText(R.string.kamineko_lyric);
        }
        if(message.equals("mogu-mogu")){
            song_name_text.setText(R.string.mogu_name);
            release_date_text.setText(R.string.mogu_release);
            lyric.setText(R.string.mogu_lyric);
        }
        if(message.equals("lazy-roop")){
            song_name_text.setText(R.string.lazy_name);
            release_date_text.setText(R.string.lazy_release);
            lyric.setText(R.string.lazy_lyric);
        }
    }
    public void goBack(View view) {
        finish();
    }
}