package com.example.twoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int text_req = 1;
    private EditText input_msg;
    private String send_msg;
    private TextView rep_head;
    private TextView rep_show;
    public static final String MSG_TAG = "msg_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_msg = findViewById(R.id.edt_message);
        rep_head = findViewById(R.id.reply_text_header);
        rep_show = findViewById(R.id.reply_text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == text_req){
            if(resultCode == RESULT_OK){
                rep_head.setVisibility(View.VISIBLE);
                rep_show.setVisibility(View.VISIBLE);
                String rep_message = data.getStringExtra(SecondActivity.REP_TAG).toString();
                rep_show.setText(rep_message);
            }
        }
    }

    public void secondAct(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        send_msg = input_msg.getText().toString();
        intent.putExtra(MSG_TAG, send_msg);
        startActivityForResult(intent, text_req);
    }
}