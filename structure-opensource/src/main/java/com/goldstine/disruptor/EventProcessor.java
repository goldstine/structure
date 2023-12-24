package com.goldstine.disruptor;

public interface EventProcessor extends Runnable{
    Sequence getSequence();

    void halt();

    boolean isRunnning();
}
