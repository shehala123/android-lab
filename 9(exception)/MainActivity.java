package com.example.exception;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] persons={"person1", "person2","person3","peron4"};
    Button clickMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickMe=findViewById(R.id.click_me);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Toast.makeText(getApplicationContext(),persons[5],Toast.LENGTH_SHORT).show();

                }catch (ArrayIndexOutOfBoundsException e){

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Caught Exception",Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}