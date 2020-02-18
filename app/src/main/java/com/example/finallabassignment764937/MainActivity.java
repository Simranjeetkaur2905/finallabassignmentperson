package com.example.finallabassignment764937;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstname , lastname , address , phonenumber;
    Button addperson;
    TextView viewinformation;

    DatabaseHelperPerson mDataBase;

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



        mDataBase = new DatabaseHelperPerson(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnaddperson:
                addingPerson();
                break;

            case R.id.tvviewperson:
              //  Intent

                Intent intent = new Intent (MainActivity.this,Personactivity.class);
                startActivity(intent);
            break;
        }



    }

    private void addingPerson() {
        String first_name = firstname.getText().toString().trim();
        String last_name = lastname.getText().toString().trim();
        String phone_number = phonenumber.getText().toString().trim();
        String address_person = address.getText().toString().trim();


        //using the calender object to get the current time

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningdate = sdf.format(calendar.getTime());

        if (first_name.isEmpty()){
            firstname.setError("name field is empty");
            firstname.requestFocus();
            return;
        }
        if (last_name.isEmpty()){
            lastname.setError("salary field is empty");
            lastname.requestFocus();
            return;
        }
        if (phone_number.isEmpty()){
            phonenumber.setError("salary field is empty");
            phonenumber.requestFocus();
            return;
        }
        if (address_person.isEmpty()){
            address.setError("salary field is empty");
            address.requestFocus();
            return;
        }

        /*
        String sql = "INSERT INTO employees(name, department, joiningdate , salary)" +
                "VALUES (?,?,?,?)";
        mDataBase.execSQL(sql ,new String[]{name,dept,joiningdate,salary});
                Toast.makeText(this, "Employee added", Toast.LENGTH_SHORT).show();

         */


        //new method
        if (mDataBase.addPerson(first_name,last_name,phone_number,address_person))
            Toast.makeText(this, "Employee added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Employee not added", Toast.LENGTH_SHORT).show();


    }

}
