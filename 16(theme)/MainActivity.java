package com.example.theme;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // setTheme(R.style.MyTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn_theme);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTheme();
            }
        });
    }

    private void changeTheme()
    {
        setTheme(R.style.MyTheme);
        setContentView(R.layout.activity_main);

    }
}