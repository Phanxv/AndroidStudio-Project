package com.example.twoactivitieschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String MSG_TAG = "msg_tag";
    public static final int text_req = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void kamiAct(View view) {
        Log.d(LOG_TAG, "Kami-sama Button Clicked");
        String send_msg = "kami-sama";
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MSG_TAG, send_msg);
        startActivityForResult(intent, text_req);
    }

    public void moguAct(View view) {
        Log.d(LOG_TAG, "Mogu Button Clicked");
        String send_msg = "mogu-mogu";
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MSG_TAG, send_msg);
        startActivityForResult(intent, text_req);
    }

    public void lazyAct(View view) {
        Log.d(LOG_TAG, "Lazy Button Clicked");
        String send_msg = "lazy-roop";
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MSG_TAG, send_msg);
        startActivityForResult(intent, text_req);
    }
}