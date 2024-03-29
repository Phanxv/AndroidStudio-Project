package com.example.whowrotethis;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    public FetchBook(TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemArray.length() && (authors == null && title == null)){
                JSONObject book = itemArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
            if(title != null && authors != null){
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            } else {
                mTitleText.get().setText("No result");
                mAuthorText.get().setText("");
            }
        } catch (JSONException e) {
            mTitleText.get().setText("No result");
            mAuthorText.get().setText("");
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
}
