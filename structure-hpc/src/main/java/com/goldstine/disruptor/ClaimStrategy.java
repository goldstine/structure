package com.goldstine.disruptor;

public interface ClaimStrategy {
    int getBufferSize();

    long getSequence();

    boolean hasAvailableCapacity(final int availableCapacity,final Sequence[] dependentSequences);

    long incrementAndGet(final Sequence[] dependentSequences);

    long incrementAndGet(final int delta,final Sequence[] dependentSequences);

    void setSequence(final long sequence,final Sequence[] dependentSequences);

    void serialisePublishing(final long sequence,final Sequence cursor,final int batchSize);

    long checkAndIncrement(int availableCapacity,int delta,Sequence[] gatingSequences)throws InsufficientCapacityException;


}
