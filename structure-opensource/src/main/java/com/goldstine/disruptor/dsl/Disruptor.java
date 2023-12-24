package com.goldstine.disruptor.dsl;

import com.goldstine.disruptor.RingBuffer;

import java.util.concurrent.Executor;

public class Disruptor<T> {
    private final RingBuffer<T> ringBuffer;
    private final Executor executor;
    private final ConsumerRepository<T> consumerRepository=new ConsumerRepository<>();



    private Disruptor(RingBuffer<T> ringBuffer, Executor executor){
        this.ringBuffer=ringBuffer;

    }

}
