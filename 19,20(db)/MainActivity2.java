package com.example.db;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

            case R.id.button:fetchData();break;
            case R.id.btn_update:
                dbHelper.update(1,"update first name","updated last name","updated gender");
                fetchData();
                break;

            case R.id.btn_delete:
                dbHelper.delete(1);
                fetchData();
                break;

        }
    }

    TextView fNmame,lName,gender;
    Button btnFetch,btnUpdate,btnDelete;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initUI();

        dbHelper=new DBHelper(this);
        btnFetch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void initUI()
    {
        fNmame=findViewById(R.id.tv_fname);
        lName=findViewById(R.id.tv_lname);
        gender=findViewById(R.id.tv_gender);
        btnFetch=findViewById(R.id.button);
        btnDelete=findViewById(R.id.btn_delete);
        btnUpdate=findViewById(R.id.btn_update);

    }

    private void fetchData()
    {
        Cursor cursor=dbHelper.getData();

        cursor.moveToFirst();

        fNmame.setText("First Name "+cursor.getString(1));
        lName.setText("Last Name "+cursor.getString(2));
        gender.setText("Gender "+cursor.getString(3));

    }


}