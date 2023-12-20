package com.example.impintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtWeb, mEdtLoc, mEdtShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtWeb = findViewById(R.id.edt_web);
        mEdtLoc = findViewById(R.id.edt_loc);
        mEdtShare = findViewById(R.id.edt_share);
    }

    public void open_site(View view) {
        String url = mEdtWeb.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intent", "Cannot handle request");
        }
    }

    public void open_location(View view) {
        String loc = mEdtLoc.getText().toString();
        Uri address = Uri.parse("geo:0,0?q="+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intent", "Cannot handle request");
        }
    }

    public void share_text(View view) {
        String txt = mEdtShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Pick your app : ")
                .setText(txt)
                .startChooser();
    }
}