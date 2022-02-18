package com.example.validation;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fNmame,lName,password;
    Button submit;
    RadioGroup genderRgroup;
    RadioButton male,female;
    Switch newMember;
    CheckBox isAgree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validate())
                {
                    Toast.makeText(getApplicationContext(),"All data is valid",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Some data is invalid",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private void initUI()
    {
        fNmame=findViewById(R.id.editText);
        lName=findViewById(R.id.editText2);
        male=findViewById(R.id.radio_male);
        female=findViewById(R.id.radio_female);
        submit=findViewById(R.id.btn_submit);
        genderRgroup=findViewById(R.id.radioGroup);
        newMember=findViewById(R.id.switch1);
        isAgree=findViewById(R.id.checkBox);
        password=findViewById(R.id.editTextTextPassword);

    }
    private boolean validate()
    {
        boolean isValid=false;

        String firstName=fNmame.getText().toString();
        String lastName=lName.getText().toString();
        String pwd=password.getText().toString();



        if(firstName.equals(""))
        {
            Toast.makeText(this,"FirstName is empty",Toast.LENGTH_SHORT).show();
        }
        else if(lastName.isEmpty())
        {
            Toast.makeText(this,"Last name is empty",Toast.LENGTH_SHORT).show();
        }
        else if(!male.isChecked()&&!female.isChecked())
        {
            Toast.makeText(this,"Please choose gender",Toast.LENGTH_SHORT).show();
        }
        else if(pwd.length()<3)
        {
            Toast.makeText(this,"Password should have at least 3 letters",Toast.LENGTH_SHORT).show();
        }
        else  if(!newMember.isChecked())
        {
            Toast.makeText(this,"new member ",Toast.LENGTH_SHORT).show();
        }
        else  if(!isAgree.isChecked())
        {
            Toast.makeText(this,"Please agree to the terms ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            isValid=true;
        }

        return isValid;

    }
}