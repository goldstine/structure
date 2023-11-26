package com.goldstine.disruptor;

public class TimeoutException extends Exception{

    public static final TimeoutException INSTANCE=new TimeoutException();

    private TimeoutException(){

    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
