package com.example.finallabassignment764937;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstname , lastname , address , phonenumber;
    Button addperson;
    TextView viewinformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        firstname = findViewById(R.id.edittextfirstname);
        lastname = findViewById(R.id.edittextlastname);
        address = findViewById(R.id.edittextaddress);
        phonenumber = findViewById(R.id.edittextphone);

        findViewById(R.id.btnaddperson).setOnClickListener(this);

        findViewById(R.id.tvviewperson).setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnaddperson:
                addingperson();
                break;

            case R.id.tvviewperson:
              //  Intent

            break;
        }



    }
}
