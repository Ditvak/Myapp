package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ArrayList<String> trains = new ArrayList();
    ArrayAdapter<String> adapter;

    ArrayList<String> selectedtrains = new ArrayList();
    ListView trainsList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        trains.add("Train 1");
        trains.add("Train 2");

        trainsList = findViewById(R.id.trainsList);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, trains);
        trainsList.setAdapter(adapter);
        trainsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                String phone = adapter.getItem(position);
                if(trainsList.isItemChecked(position)==true){
                    selectedtrains.add(phone);
                }
                else{

                    selectedtrains.remove(phone);
                }
            }
        });
    }

    public void add(View view){

        EditText phoneEditText = findViewById(R.id.train);
        String phone = phoneEditText.getText().toString();
        if(!phone.isEmpty() && trains.contains(phone)==false){
            adapter.add(phone);
            phoneEditText.setText("");
            adapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        for(int i=0; i< selectedtrains.size();i++){
            adapter.remove(selectedtrains.get(i));
        }
        trainsList.clearChoices();
        selectedtrains.clear();
        adapter.notifyDataSetChanged();
    }
}


