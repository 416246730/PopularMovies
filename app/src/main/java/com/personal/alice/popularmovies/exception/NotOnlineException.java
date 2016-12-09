package com.personal.alice.popularmovies.exception;

/**
 * Created by alice on 2016/11/29.
 */

public class NotOnlineException extends Exception {

    public NotOnlineException() {
        super("没有网络连接");
    }
}
