package com.goldstine.disruptor;

public class InsufficientCapacityException extends Exception{

    public static final InsufficientCapacityException INSTANCE=new InsufficientCapacityException();

    private InsufficientCapacityException(){

    }

    @Override
    public synchronized Throwable fillInStackTrace(){
        return this;
    }
}
