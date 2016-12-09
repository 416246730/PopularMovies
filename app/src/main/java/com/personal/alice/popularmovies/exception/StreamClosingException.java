package com.personal.alice.popularmovies.exception;

/**
 * Created by alice on 2016/11/28.
 */

public class StreamClosingException extends Exception {
    public StreamClosingException() {
        super("Stream 关闭异常！");
    }
}
