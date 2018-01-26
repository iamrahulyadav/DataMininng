package com.example.mohamadhasan.dataminning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamadhasan.dataminning.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class favoriteActivity extends AppCompatActivity {

    private Spinner[] spinner = new Spinner[19];
    private List<String> ratings;
    private double[] userRating = new double[19];
    private Button btnDone;

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
        spinner[0].setAdapter(dataAdapter);
        spinner[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[0] = getRatingFromSelectedItem(position);
                Log.i("LOG", userRating[0] + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[1].setAdapter(dataAdapter);
        spinner[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[1] = getRatingFromSelectedItem(position);
                Log.i("LOG", userRating[1] + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[2].setAdapter(dataAdapter);
        spinner[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[2] = getRatingFromSelectedItem(position);
                Log.i("LOG", userRating[2] + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[3].setAdapter(dataAdapter);
        spinner[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[3] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[4].setAdapter(dataAdapter);
        spinner[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[4] = getRatingFromSelectedItem(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[5].setAdapter(dataAdapter);
        spinner[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[5] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[6].setAdapter(dataAdapter);
        spinner[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[6] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[7].setAdapter(dataAdapter);
        spinner[7].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[7] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[8].setAdapter(dataAdapter);
        spinner[8].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[8] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[9].setAdapter(dataAdapter);
        spinner[9].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[9] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[10].setAdapter(dataAdapter);
        spinner[10].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[10] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[11].setAdapter(dataAdapter);
        spinner[11].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[11] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[12].setAdapter(dataAdapter);
        spinner[12].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[12] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[13].setAdapter(dataAdapter);
        spinner[13].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[13] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[14].setAdapter(dataAdapter);
        spinner[14].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[14] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[15].setAdapter(dataAdapter);
        spinner[15].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[15] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[16].setAdapter(dataAdapter);
        spinner[16].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[16] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[17].setAdapter(dataAdapter);
        spinner[17].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[17] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner[18].setAdapter(dataAdapter);
        spinner[18].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.darkgrey));
                userRating[18] = getRatingFromSelectedItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbCallBack dbCallBack = new dbCallBack();
                dbCallBack.execute();
            }
        });


    }


    public double getRatingFromSelectedItem(int position) {
        switch (position) {
            case 0:
                return 1;
            case 1:
                return 0.8;
            case 2:
                return 0.6;
            case 3:
                return 0.4;
            case 4:
                return 0.2;
            default:
                return 0;
        }
    }


    private void initView() {
        spinner[0] = findViewById(R.id.Spinner1);
        spinner[1] = findViewById(R.id.Spinner2);
        spinner[2] = findViewById(R.id.Spinner3);
        spinner[3] = findViewById(R.id.Spinner4);
        spinner[4] = findViewById(R.id.Spinner5);
        spinner[5] = findViewById(R.id.Spinner6);
        spinner[6] = findViewById(R.id.Spinner7);
        spinner[7] = findViewById(R.id.Spinner8);
        spinner[8] = findViewById(R.id.Spinner9);
        spinner[9] = findViewById(R.id.Spinner10);
        spinner[10] = findViewById(R.id.Spinner11);
        spinner[11] = findViewById(R.id.Spinner12);
        spinner[12] = findViewById(R.id.Spinner13);
        spinner[13] = findViewById(R.id.Spinner14);
        spinner[14] = findViewById(R.id.Spinner15);
        spinner[15] = findViewById(R.id.Spinner16);
        spinner[16] = findViewById(R.id.Spinner17);
        spinner[17] = findViewById(R.id.Spinner18);
        spinner[18] = findViewById(R.id.Spinner19);
        btnDone = findViewById(R.id.btnDone);

    }

    private class dbCallBack extends AsyncTask<Object, Void, Void> {

        private DatabaseHelper helper;
        String name, pass;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            helper = new DatabaseHelper(getApplicationContext());
            SharedPreferences prefs = getSharedPreferences("MYPREFS", 0);
            name = prefs.getString("USERNAME", "");
            pass = prefs.getString("PASS", "");
        }

        @Override
        protected Void doInBackground(Object... params) {

            helper.updateTbl_user(userRating, name, pass);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

                Intent intent = new Intent(favoriteActivity.this, MainActivity.class);
                startActivity(intent);

        }
    }


}
