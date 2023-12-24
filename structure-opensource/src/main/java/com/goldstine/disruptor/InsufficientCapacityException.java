package com.goldstine.disruptor;

public class InsufficientCapacityException extends Exception{
//空间不足异常
    public static final InsufficientCapacityException INSTANCE=new InsufficientCapacityException();

    private InsufficientCapacityException(){

    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
