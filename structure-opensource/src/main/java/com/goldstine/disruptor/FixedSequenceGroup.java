package com.goldstine.disruptor;

import com.goldstine.disruptor.util.Util;

import java.util.Arrays;

public final class FixedSequenceGroup extends Sequence{
    private final Sequence[] sequences;

    public FixedSequenceGroup(Sequence[] sequences){
        this.sequences= Arrays.copyOf(sequences,sequences.length);
    }

    @Override
    public long get() {
        return Util.getMinimumSequence(sequences);
    }

    @Override
    public void set(long value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean compareAndSet(long expectedValue, long newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return Arrays.toString(sequences);
    }

    @Override
    public long incrementAndGet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long addAndGet(long increment) {
        throw new UnsupportedOperationException();
    }
}
