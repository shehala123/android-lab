package com.example.explicit_intent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tview;
    EditText edValueReturn;
    Button btnReturn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tview=findViewById(R.id.tview);
        edValueReturn=findViewById(R.id.ed_return);
        btnReturn=findViewById(R.id.btn_return);

        Bundle bundle=getIntent().getExtras();

        tview.setText("Value passed: "+bundle.getString("DATA"));


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                Bundle b=new Bundle();
                b.putString("DATA",edValueReturn.getText().toString());
                intent.putExtras(b);

                setResult(RESULT_OK,intent);
                finish();
            }
        });



    }
}