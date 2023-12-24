package com.goldstine.disruptor;

public interface WorkHandler <T>{
    void onEvent(T event)throws Exception;
}
