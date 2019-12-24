package com.example.myapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class FourthActivity extends ListActivity implements AdapterView.OnItemLongClickListener{

     String[] notes = new String[]{};

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> Names = new ArrayList<>(Arrays.asList(notes));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);


        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Names);
        setListAdapter(mAdapter);
        getListView().setOnItemLongClickListener(this);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case (0):
                Intent browserIntent0 = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://rozetka.com.ua/ua/"));
                startActivity(browserIntent0);
                break;
        }

        Toast.makeText(getApplicationContext(),"Вы выбрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();

        mAdapter.remove(selectedItem);
        mAdapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(),
                selectedItem + " удалён.",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}