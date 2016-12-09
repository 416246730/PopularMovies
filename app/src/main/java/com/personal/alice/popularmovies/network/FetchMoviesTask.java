package com.personal.alice.popularmovies.network;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.personal.alice.popularmovies.exception.NotOnlineException;
import com.personal.alice.popularmovies.exception.StreamClosingException;
import com.personal.alice.popularmovies.models.Movie;
import com.personal.alice.popularmovies.models.MovieQueryObj;
import com.personal.alice.popularmovies.network.result.FetchMovieResult;
import com.personal.alice.popularmovies.util.HttpURLConnectionUtil;
import com.personal.alice.popularmovies.views.adapters.MovieAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by alice on 2016/11/28.
 */

public class FetchMoviesTask extends AsyncTask<Object,Void,ArrayList<Movie>> {

    private String TAG = FetchMoviesTask.class.getSimpleName();

    private final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    private MovieAdapter mMovieAdapter;
    private Context mContext;

    public FetchMoviesTask( Context context,MovieAdapter movieAdapter){
        mMovieAdapter = movieAdapter;
        mContext = context;
    }

    @Override
    protected ArrayList<Movie> doInBackground(Object... params) {
       MovieQueryObj query = null;
        try{
             query = (MovieQueryObj)params[0];
        }catch (ClassCastException e){
            Log.e(TAG, "doInBackground: 参数异常！",e);
            return null;
        }

        final String API_KEY_PARAM = "api_key";
        final String LANGUAGE_PARAM = "language";
        final String PAGE_PARAM = "page";
        Uri builtUri = Uri.parse(BASE_URL+query.getSort()+"?").buildUpon()
                .appendQueryParameter(API_KEY_PARAM,query.getApiKey())
                .appendQueryParameter(LANGUAGE_PARAM, query.getLanguage())
                .appendQueryParameter(PAGE_PARAM, query.getPage().toString())
                .build();
        String backStr = null;
        try {
            backStr = HttpURLConnectionUtil.get(mContext, new URL(builtUri.toString()));
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: ", e);
        } catch (StreamClosingException e) {
            Log.e(TAG, "doInBackground: ", e);
        } catch (NotOnlineException e) {
            Log.e(TAG, "doInBackground: ", e);
        }

        try{
            Gson gson = new Gson();
            FetchMovieResult rs = gson.fromJson(backStr,FetchMovieResult.class);
            ArrayList<Movie> movies = new ArrayList<>();
            for(Movie movie : rs.getResults()){
                movies.add(movie);
            }
            return movies;
        }catch (JsonSyntaxException e){
            Log.e(TAG, "doInBackground: ", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> movies) {
        if (movies != null) {
            mMovieAdapter.setMovies(movies);
            mMovieAdapter.notifyDataSetChanged();
        }
    }

}
