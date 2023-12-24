package com.goldstine.disruptor;

public final class RingBuffer<E> extends RingBufferFields<E> implements Cursored ,EventSequencer<E> ,EventSink<E> {

    @Override
    public long getCursor() {
        return 0;
    }

    @Override
    public E get(long sequence) {
        return null;
    }
}
