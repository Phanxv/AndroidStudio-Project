package com.example.asynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        if(savedInstanceState != null){
            mTextView.setText(savedInstanceState.getString("Current Text"));
        }
    }

    public void startTask(View view) {
        mTextView.setText("eepy.....");
        new SimpleAsync(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Current Text", mTextView.getText().toString());
    }
}