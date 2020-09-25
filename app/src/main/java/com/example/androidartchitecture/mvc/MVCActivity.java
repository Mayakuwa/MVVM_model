package com.example.androidartchitecture.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidartchitecture.R;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC Activity");

        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVCActivity.this, "you clicked" + listValues.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> vals = new ArrayList<>();
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");

        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");

        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");

        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");

        setValues(vals);
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        adapter.notifyDataSetChanged();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }
}