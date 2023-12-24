package com.goldstine.disruptor.dsl;

import com.goldstine.disruptor.Sequence;

import java.util.concurrent.Executor;

public interface ConsumerInfo {
    Sequence[] getSequences();

    SequenceBarrier getBarrier();

    boolean isEndOfChain();

    void start(Executor executor);

    void halt();

    void markAsUsedInBarrier();

    boolean isRunning();
}
