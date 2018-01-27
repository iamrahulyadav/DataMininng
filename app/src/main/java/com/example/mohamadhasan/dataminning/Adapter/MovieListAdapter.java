package com.example.mohamadhasan.dataminning.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mohamadhasan.dataminning.MovieModel;
import com.example.mohamadhasan.dataminning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EHSAN on 1/27/2018.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<MovieModel> movieList = new ArrayList<>();


    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listitem_movie, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        final MovieModel currentObj = movieList.get(position);
        holder.setData(currentObj, position);

        //holder.rating.setRating(Float.parseFloat("2.0"));
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtRating;
        private TextView txtGeners;
        private ImageView imgTitle;

        int position;
        public MovieModel current;


        myViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);
            txtGeners = (TextView) itemView.findViewById(R.id.txtGeners);
            imgTitle = (ImageView) itemView.findViewById(R.id.imgTitle);

        }

        private void setData(MovieModel current, int position) {

            this.txtName.setText(current.title);
            this.txtRating.setText(current.overAllRating + "");
            //this.imgNews.setImageResource();

            this.txtGeners.setText("ژانر: ");

            for (int i = 0; i < current.movieRating.length; i++) {

                if (current.movieRating[i] == 1) {

                    switch (i) {
                        case 0:
                            this.txtGeners.setText(txtGeners.getText().toString() + "اکشن" + "|" );
                            break;
                        case 1:
                            this.txtGeners.setText(txtGeners.getText().toString() + "ماجراجویی" + "|" );
                            break;
                        case 2:
                            this.txtGeners.setText(txtGeners.getText().toString() + "انیمیشن" + "|" );
                            break;
                        case 3:
                            this.txtGeners.setText(txtGeners.getText().toString() + "کودک و نو جوان" + "|" );
                            break;
                        case 4:
                            this.txtGeners.setText(txtGeners.getText().toString() + "کمدی" + "|" );
                            break;
                        case 5:
                            this.txtGeners.setText(txtGeners.getText().toString() + "فانتزی" + "|" );
                            break;
                        case 6:
                            this.txtGeners.setText(txtGeners.getText().toString() + "آی مکس" + "|" );
                            break;
                        case 7:
                            this.txtGeners.setText(txtGeners.getText().toString() + "رومانس" + "|" );
                            break;
                        case 8:
                            this.txtGeners.setText(txtGeners.getText().toString() + "علمی تخیلی" + "|" );
                            break;
                        case 9:
                            this.txtGeners.setText(txtGeners.getText().toString() + "کابوی" + "|" );
                            break;
                        case 10:
                            this.txtGeners.setText(txtGeners.getText().toString() + "رازآلود" + "|" );
                            break;
                        case 11:
                            this.txtGeners.setText(txtGeners.getText().toString() + "جنایی" + "|" );
                            break;
                        case 12:
                            this.txtGeners.setText(txtGeners.getText().toString() + "درام" + "|" );
                            break;
                        case 13:
                            this.txtGeners.setText(txtGeners.getText().toString() + "ترسناک" + "|" );
                            break;
                        case 14:
                            this.txtGeners.setText(txtGeners.getText().toString() + "مهیج" + "|" );
                            break;
                        case 15:
                            this.txtGeners.setText(txtGeners.getText().toString() + "سیاه و سفید" + "|" );
                            break;
                        case 16:
                            this.txtGeners.setText(txtGeners.getText().toString() + "مستند" + "|" );
                            break;
                        case 17:
                            this.txtGeners.setText(txtGeners.getText().toString() + "جنگی" + "|" );
                            break;
                        case 18:
                            this.txtGeners.setText(txtGeners.getText().toString() + "موزیکال" + "|" );
                            break;

                    }

                }

            }

            this.position = position;
            this.current = current;

        }


    }

}