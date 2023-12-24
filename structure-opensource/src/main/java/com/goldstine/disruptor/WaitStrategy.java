package com.goldstine.disruptor;

import java.util.concurrent.TimeoutException;

public interface WaitStrategy {
    long waitFor(long sequence,Sequence cursor,Sequence dependentSequence,SequenceBarrier barrier) throws AlertException,InterruptedException, TimeoutException;

    void signalAllWhenBlocking();
}
