package com.example.explicit_intent;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnImplicit,btnExplicit;
    TextView tviewResult;


    private final int DATA_REQ=101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicit=findViewById(R.id.btn_implicit);
        btnExplicit=findViewById(R.id.btn_explicit);
        tviewResult=findViewById(R.id.result_tview);



        btnExplicit.setOnClickListener(this);
        btnImplicit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_implicit:

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(i);
                break;

            case R.id.btn_explicit:

                Intent intent=new Intent(this,MainActivity2.class);
                Bundle bundle=new Bundle();
                bundle.putString("DATA","This is the data passed from activity 1");
                intent.putExtras(bundle);
                startActivityForResult(intent,DATA_REQ);
                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==DATA_REQ&&resultCode==RESULT_OK)
        {
            Bundle b=data.getExtras();

            tviewResult.setText(b.getString("DATA"));
        }

    }
}