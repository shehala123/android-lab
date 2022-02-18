package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    String[] names={"John F Kennedy","Abraham Lincoln","Mahathma Gandhi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
    }

    private  void initUI()
    {
        listView=findViewById(R.id.l_view);
    }
}