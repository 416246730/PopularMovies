package com.personal.alice.popularmovies.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.personal.alice.popularmovies.R;
import com.personal.alice.popularmovies.models.Movie;
import com.personal.alice.popularmovies.util.PicassoUtil;
import com.personal.alice.popularmovies.views.adapters.MovieAdapter;

/**
 * Created by alice on 2016/11/27.
 */

public class DetailFragment extends Fragment {

    public  static String EXTRA_MOVIE = "MOVIE";

    private Movie mMovie;
    private MovieAdapter mMovieAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_movie_detail,container,false);
        Intent intent = getActivity().getIntent();
        mMovie=(Movie)intent.getSerializableExtra(EXTRA_MOVIE);

        TextView toolbar = (TextView) rootView.findViewById(R.id.textView_movie_title);
        toolbar.setText(mMovie.getTitle());

        ImageView imgView = (ImageView)rootView.findViewById(R.id.imageView_movie_pic);
        PicassoUtil.loagPic(getActivity(),imgView,mMovie.getPoster_path_small());

        TextView  releaseDate = (TextView)rootView.findViewById(R.id.textView_movie_release_date);
        releaseDate.setText( mMovie.getRelease_date());


        TextView  overview = (TextView)rootView.findViewById(R.id.textView_movie_overview);
        overview.setText( mMovie.getOverview());


        TextView  voteAverage = (TextView)rootView.findViewById(R.id.textView_movie_vote_average);
        voteAverage.setText( mMovie.getVote_average()+"/10");
        return rootView;
    }

}
