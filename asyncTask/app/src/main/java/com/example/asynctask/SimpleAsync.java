package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsync extends AsyncTask {
    private WeakReference<TextView> mTextView;
    SimpleAsync(TextView tv){
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Woke up after " + s + "ms of sleep";
    }

    @Override
    protected void onPostExecute(Object o) {
        mTextView.get().setText(o.toString());
    }
}
