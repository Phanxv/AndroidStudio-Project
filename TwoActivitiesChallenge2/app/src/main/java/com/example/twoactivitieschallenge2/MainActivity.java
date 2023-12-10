package com.example.twoactivitieschallenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String MSG_TAG = "msg_tag";
    public static final int text_req = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String send_msg = Integer.toString(mCount);
        intent.putExtra(MSG_TAG, send_msg);
        startActivityForResult(intent, text_req);
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}