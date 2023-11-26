package com.goldstine.disruptor;

import java.util.concurrent.atomic.AtomicLongArray;

public class MultiThreadedClaimStrategy extends AbstractMultithreadedClaimStrategy implements ClaimStrategy{

    private static final int RETRIES=1000;
    private final AtomicLongArray pendingPublication;
    private final int pendingMask;

    public MultiThreadedClaimStrategy(final int bufferSize,final int pendingBufferSize){
        super(bufferSize);
        if (Integer.bitCount(pendingBufferSize) != 1) {
            throw new IllegalArgumentException("pendingBufferSize must be a power of 2,was:"+pendingBufferSize);
        }

        this.pendingPublication=new AtomicLongArray(pendingBufferSize);
        this.pendingMask=pendingBufferSize-1;
    }


    public MultiThreadedClaimStrategy(final int bufferSize)
    {
        this(bufferSize, 1024);
    }
}
