package com.personal.alice.popularmovies.models;

/**
 * Created by alice on 2016/11/28.
 */

public class MovieQueryObj {
    private String mSort;
    private String mApiKey;
    private String mLanguage = MovieLanguageEnum.CHINESE.getLanguage();//默认中文
    private Integer mPage = 1;

    public  MovieQueryObj(String sort,String apiKey){
        mSort = sort;
        mApiKey = apiKey;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        this.mApiKey = apiKey;
    }


    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        this.mLanguage = language;
    }

    public Integer getPage() {
        return mPage;
    }

    public void setPage(Integer page) {
        this.mPage = page;
    }

    public String getSort() {
        return mSort;
    }

    public void setSort(String sort) {
        mSort = sort;
    }
}
