package com.personal.alice.popularmovies.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.personal.alice.popularmovies.R;
import com.personal.alice.popularmovies.models.Movie;
import com.personal.alice.popularmovies.util.PicassoUtil;

import java.util.ArrayList;

/**
 * Created by alice on 2016/11/28.
 */

public class MovieAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Movie> mMovies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_item, null);
        ImageView imageView;
        if (convertView == null) {
            imageView = (ImageView) convertView.findViewById(R.id.imageview_img);
        } else {
            ViewGroup vg = (ViewGroup) convertView;
            imageView = (ImageView) vg.findViewById(R.id.imageview_img);
        }

        String url = mMovies.get(position).getPoster_path();

        PicassoUtil.loagPic(mContext,imageView,url);
        return imageView;
    }

}
