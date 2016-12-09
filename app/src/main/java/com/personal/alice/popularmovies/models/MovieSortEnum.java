package com.personal.alice.popularmovies.models;

/**
 * Created by alice on 2016/11/28.
 *
 * 电影分类
 */

public enum MovieSortEnum {
    POPULAR("popular"),TOP_RATED("top_rated");

    private  String mSort;
    private MovieSortEnum(String sort) {
        this.mSort = sort;
    }

    public String getSort() {
        return mSort;
    }
}
