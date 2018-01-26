package com.example.mohamadhasan.dataminning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class favoriteActivity extends AppCompatActivity {

    private Spinner Spinner1;
    private List<String> ratings;
    private int sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, sp11, sp12, sp13, sp14, sp15, sp16, sp17, sp18, sp19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        initView();

        // set data for spinner
        ratings = new ArrayList<>();
        ratings.add("خیلی زیاد");
        ratings.add("زیاد");
        ratings.add("متوسط");
        ratings.add("کم");
        ratings.add("خیلی کم");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ratings);
        dataAdapter.setDropDownViewResource(R.layout.spinner_text);

        // attaching data adapter to spinner
        Spinner1.setAdapter(dataAdapter);
        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                sp1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void initView() {
        Spinner1 = (Spinner) findViewById(R.id.Spinner1);
    }
}
