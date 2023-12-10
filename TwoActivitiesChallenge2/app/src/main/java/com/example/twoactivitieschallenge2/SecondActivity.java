package com.example.twoactivitieschallenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String count_msg = intent.getStringExtra(MainActivity.MSG_TAG);
        TextView count_view = findViewById(R.id.show_count);
        count_view.setText(count_msg);
    }
}