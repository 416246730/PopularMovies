package com.personal.alice.popularmovies.models;

import java.io.Serializable;

/**
 * Created by alice on 2016/11/28.
 */

public class Movie implements Serializable{
    private Integer id;
    private String poster_path;
    private String overview;
    private String title;
    private String release_date;
    private String vote_average;

    public Movie(){

    }

    public Movie(Integer id, String poster_path) {
        this.id = id;
        this.poster_path = poster_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoster_path() {
        return "http://image.tmdb.org/t/p/w185/"+poster_path;
    }

    public  String getPoster_path_small(){
        return "http://image.tmdb.org/t/p/w92/"+poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
