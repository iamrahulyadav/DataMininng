package com.example.mohamadhasan.dataminning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohamadhasan.dataminning.Adapter.MovieListAdapter;
import com.example.mohamadhasan.dataminning.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private double[] userRating = new double[19];
    private List<MovieModel> movieList;
    private List<MovieModel> favoriteMovieList;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRating = getIntent().getDoubleArrayExtra("UserRating");

        recycler = findViewById(R.id.recycler);

        dbCallBack dbCallBack = new dbCallBack();
        dbCallBack.execute();


    }


    private class dbCallBack extends AsyncTask<Object, Void, Void> {

        private DatabaseHelper helper;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            helper = new DatabaseHelper(getApplicationContext());
            movieList = new ArrayList<>();
            favoriteMovieList = new ArrayList<>();
        }

        @Override
        protected Void doInBackground(Object... params) {

            movieList = helper.selectAllMovies();

            double sumSoorat = 0;
            double sumMakhraj = 0;
            double result = 0;
            boolean flagSort;

            for (int i = 0; i < 19; i++) {
                sumMakhraj += userRating[i];
            }

            if (movieList.size() > 0) {


                for (int j = 0; j < movieList.size(); j++) {
                    sumSoorat = 0;
                    for (int i = 0; i < 19; i++) {

                        sumSoorat += (Math.pow((userRating[i] - movieList.get(j).movieRating[i]), 2)) * userRating[i];

                    }

                    result = Math.sqrt(sumSoorat / sumMakhraj);
                    movieList.get(j).overAllRating = result;

                    favoriteMovieList.add(movieList.get(j));


                }

                int l;
                for (int k = 0; k < favoriteMovieList.size() - 1; k++){

                    l = k;

                    while (l > -1 && favoriteMovieList.get(l).overAllRating > favoriteMovieList.get(l + 1).overAllRating){

                        favoriteMovieList.add(l, favoriteMovieList.get(l + 1));
                        favoriteMovieList.remove(l + 2);

                        l--;

                    }

                }


            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (favoriteMovieList.size() > 0)
                setUpRecyclerView(favoriteMovieList);


        }
    }


    private void setUpRecyclerView(List<MovieModel> List) {

        MovieListAdapter adapter = new MovieListAdapter(this, List);
        recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }


}
