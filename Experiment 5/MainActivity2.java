package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView fname,lname,gender;
    Button btnFetch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUI();

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData();
            }
        });

    }
    private void initUI()
    {
        fname=findViewById(R.id.tv_fname);
        lname=findViewById(R.id.tv_lname);
        gender=findViewById(R.id.tv_gender);
        btnFetch=findViewById(R.id.button);
    }

    private void fetchData()
    {
        SharedPreferences sharedPref = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        fname.setText("First Name "+sharedPref.getString("FNAME",""));
        lname.setText("Last Name "+sharedPref.getString("LNAME",""));
        gender.setText("Gender "+sharedPref.getString("GENDER",""));

    }


}