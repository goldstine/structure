package com.goldstine.disruptor;

import java.util.concurrent.TimeoutException;

public class YieldingWaitStrategy implements WaitStrategy{
    @Override
    public long waitFor(long sequence, Sequence cursor, Sequence dependentSequence, SequenceBarrier barrier) throws AlertException, InterruptedException, TimeoutException {
        return 0;
    }

    @Override
    public void signalAllWhenBlocking() {

    }
}
