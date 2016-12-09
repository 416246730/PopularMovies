package com.personal.alice.popularmovies.models;

/**
 * Created by alice on 2016/11/28
 *
 *
 * 电影语言类型
 */

public enum MovieLanguageEnum {
    ENGLISH("en_US"),//英语
    CHINESE("zh");//中文

    private  String mLanguage;
    private MovieLanguageEnum(String language) {
        this.mLanguage = language;
    }

    public String getLanguage() {
        return mLanguage;
    }
}
