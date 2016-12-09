package com.personal.alice.popularmovies.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.personal.alice.popularmovies.BuildConfig;
import com.personal.alice.popularmovies.DetailActivity;
import com.personal.alice.popularmovies.R;
import com.personal.alice.popularmovies.SettingsActivity;
import com.personal.alice.popularmovies.models.Movie;
import com.personal.alice.popularmovies.models.MovieQueryObj;
import com.personal.alice.popularmovies.network.FetchMoviesTask;
import com.personal.alice.popularmovies.views.adapters.MovieAdapter;

import java.util.ArrayList;

/**
 * Created by alice on 2016/11/27.
 */

public class MoviesFragment extends Fragment {

    private MovieAdapter mMovieAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_movies, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            updateMovies();
            return true;
        }
        if (id == R.id.action_settings) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_movie_list,container,false);
        ArrayList<Movie> arr = new ArrayList<>();

        mMovieAdapter = new MovieAdapter(rootView.getContext(),arr);
        GridView gridview = (GridView) rootView.findViewById(R.id.gridview_movies);
        gridview.setAdapter(mMovieAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = mMovieAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(DetailFragment.EXTRA_MOVIE, movie);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        updateMovies();

        return rootView;
    }


    private void updateMovies() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sort = prefs.getString(getString(R.string.pref_favor_key), getString(R.string.pref_favor_popular));
        MovieQueryObj query = new MovieQueryObj(sort, BuildConfig.THE_MOVIE_DB_API_KEY);
        FetchMoviesTask task = new FetchMoviesTask(getActivity(), mMovieAdapter);
        task.execute(query);
    }
}
