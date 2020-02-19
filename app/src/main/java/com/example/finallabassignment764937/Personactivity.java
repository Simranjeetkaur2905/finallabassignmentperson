package com.example.finallabassignment764937;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Personactivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    DatabaseHelperPerson mDataBase;
    List<Person> personList;
    ListView listView;

    ArrayList<String> arrayList = new ArrayList<>();


    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personactivity);
        searchView = findViewById(R.id.searchbar);

        listView = findViewById(R.id.lvpersons);
        personList = new ArrayList<>();
        mDataBase =   new DatabaseHelperPerson(this);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);


        loadPerson();
setUpSearchView();

    }


    private void setUpSearchView(){
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search here");
    }



    private void loadPerson() {
        Cursor cursor = mDataBase.getAllPerson();
        if(cursor.moveToFirst()){
            do {
                personList.add(new Person(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));


            }while (cursor.moveToNext());
            cursor.close();
            //show item in a listView
            //we use a custom adapter to show employees

              PersonAdapter personAdapter = new PersonAdapter(this, R.layout.list_layout_person, personList, mDataBase);
           listView.setAdapter(personAdapter);

        }
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(TextUtils.isEmpty(newText.toString())){
            listView.clearTextFilter();
        }
        else {
            listView.setFilterText(newText.toString());
        }
        return true;
    }
}


