package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String REP_TAG = "rep_tag";
    private EditText reply_box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MSG_TAG);
        TextView recv_text = findViewById(R.id.message_text);
        recv_text.setText(message);
        reply_box = findViewById(R.id.edt_sec_message);
    }

    public void returnReply(View view) {
        String rep_msg = reply_box.getText().toString();
        Intent rep_intent = new Intent();
        rep_intent.putExtra(REP_TAG, rep_msg);
        setResult(RESULT_OK, rep_intent);
        finish();
    }
}
