package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname;
    Button submit;
    RadioGroup gendergrp;
    RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAndNavigate();
            }
        });

    }

    private void initUI() {
        fname = findViewById(R.id.editText);
        lname = findViewById(R.id.editText2);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        submit = findViewById(R.id.button);
        gendergrp = findViewById(R.id.radioGroup);
    }

    private void registerAndNavigate() {
        SharedPreferences sharedPref = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FNAME", fname.getText().toString());
        editor.putString("LNAME", lname.getText().toString());

        String radioValue = "";
        switch (gendergrp.getCheckedRadioButtonId()) {
            case R.id.male:
                radioValue = "Male";
                break;
            case R.id.female:
                radioValue = "Female";
                break;
        }
        editor.putString("GENDER", radioValue);
        editor.apply();

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}