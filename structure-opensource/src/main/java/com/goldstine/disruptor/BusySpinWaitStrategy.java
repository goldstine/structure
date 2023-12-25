package com.goldstine.disruptor;

import com.goldstine.disruptor.util.ThreadHints;

public final class BusySpinWaitStrategy implements WaitStrategy
{
    @Override
    public long waitFor(
            final long sequence, Sequence cursor, final Sequence dependentSequence, final SequenceBarrier barrier)
            throws AlertException, InterruptedException
    {
        long availableSequence;

        while ((availableSequence = dependentSequence.get()) < sequence)
        {
            barrier.checkAlert();
            ThreadHints.onSpinWait();
        }

        return availableSequence;
    }

    @Override
    public void signalAllWhenBlocking()
    {
    }
}
