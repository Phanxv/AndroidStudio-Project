package com.example.checkboxchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        String check_message = "Topping : ";
        CheckBox check_choco_syrup = (CheckBox) findViewById(R.id.check_choco_syrup);
        CheckBox check_sprinkles = (CheckBox) findViewById(R.id.check_sprinkles);
        CheckBox check_cherries = (CheckBox) findViewById(R.id.check_cherries);
        CheckBox check_nuts = (CheckBox) findViewById(R.id.check_nuts);
        CheckBox check_oreo = (CheckBox) findViewById(R.id.check_oreo);

        if (check_choco_syrup.isChecked()) {
            check_message = check_message + getString(R.string.string_chocolate_syrup) +" ";
        }
        if (check_sprinkles.isChecked()) {
            check_message = check_message + getString(R.string.string_sprinkles) + " ";
        }
        if (check_cherries.isChecked()) {
            check_message = check_message + getString(R.string.string_cherries) + " ";
        }
        if (check_nuts.isChecked()) {
            check_message = check_message + getString(R.string.string_nuts) + " ";
        }
        if (check_oreo.isChecked()) {
            check_message = check_message + getString(R.string.string_oreo) + " ";
        }
        Toast.makeText(this, check_message, Toast.LENGTH_SHORT).show();
    }
}