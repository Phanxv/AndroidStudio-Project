package com.example.whowrotethis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputManager != null){
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        mAuthorText.setText("");
        mTitleText.setText("loading...");
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean hasInternet = false;
        if(cm != null){
            Network[] networks = cm.getAllNetworks();
            for (Network nw : networks){
                NetworkCapabilities nc = cm.getNetworkCapabilities(nw);
                if(nc != null)
                    if(nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))
                        hasInternet = true;
            }
        }
        if (hasInternet && queryString.length() != 0) {
            new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("loading...");
        } else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText("No search term");
            } else {
                mAuthorText.setText("");
                mTitleText.setText("No network");
            }
        }
    }
}