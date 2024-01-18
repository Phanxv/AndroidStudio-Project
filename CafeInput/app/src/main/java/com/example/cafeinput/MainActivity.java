package com.example.cafeinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner_label);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

    }

    public void radioClicked(View view){
        Boolean check = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.sameday_radio){
            showToast("Sameday Delivery");
        }
        else if (view.getId() == R.id.nextday_radio) {
            showToast("Nextday Delivery");
        }
        else if (view.getId() == R.id.self_radio) {
            showToast("Self Pickup");
        }
    }
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}