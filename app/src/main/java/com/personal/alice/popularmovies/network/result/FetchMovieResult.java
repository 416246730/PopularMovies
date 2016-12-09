package com.personal.alice.popularmovies.network.result;

import com.personal.alice.popularmovies.models.Movie;

import java.util.ArrayList;

/**
 * Created by alice on 2016/11/28.
 */

public class FetchMovieResult {
    private Integer page;
    private ArrayList<Movie> results;
    private Integer total_results;
    private Integer total_pages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
}
