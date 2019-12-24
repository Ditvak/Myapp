package com.example.myapp;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstActivity extends ListActivity implements AdapterView.OnItemLongClickListener {

    final String[] trainThing = new String[]{"Бицепс", "Трицепс", "Бицебс бедра",
            "Квадрицепс", "Спина", "Плечи" };

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> Names = new ArrayList<>(Arrays.asList(trainThing));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Names);
        setListAdapter(mAdapter);
        getListView().setOnItemLongClickListener(this);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }
        else {
            switch (position) {
                case (0):
                    Intent browserIntent0 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://cross.expert/programmy-trenirovok/uprazhneniya-na-bitseps.html/"));
                    startActivity(browserIntent0);
                    break;
                case (1):
                    Intent browserIntent1 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://lifehacker.ru/luchshie-uprazhneniya-na-triceps/"));
                    startActivity(browserIntent1);
                    break;
                case (2):
                    Intent browserIntent2 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://hochu.ua/cat-health/fitness/article-61971-bitseps-bedra-kak-pravilno-trenirovat/"));
                    startActivity(browserIntent2);
                    break;
                case (3):
                    Intent browserIntent3 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://cross.expert/programmy-trenirovok/uprazhneniya-na-kvadritseps.html"));
                    startActivity(browserIntent3);
                    break;
                case (4):
                    Intent browserIntent4 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://lifehacker.ru/luchshie-uprazhneniya-dlya-spiny/"));
                    startActivity(browserIntent4);
                    break;
                case (5):
                    Intent browserIntent5 = new
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iphones.ru/iNotes/editrial-best-shoulder-workout"));
                    startActivity(browserIntent5);
                default:
                    break;
            }

            Toast.makeText(getApplicationContext(), "Вы выбрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        }
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



