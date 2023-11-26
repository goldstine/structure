package com.goldstine.disruptor;

public class AbstractMultithreadedClaimStrategy implements ClaimStrategy{

    private final int bufferSize;
    private final Sequence claimSequence=new Sequence(Sequencer.INITIAL_CURSOR_VALUE);

    public AbstractMultithreadedClaimStrategy(int bufferSize)
    {
        this.bufferSize = bufferSize;
    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public long getSequence() {
        return 0;
    }

    @Override
    public boolean hasAvailableCapacity(int availableCapacity, Sequence[] dependentSequences) {
        return false;
    }

    @Override
    public long incrementAndGet(Sequence[] dependentSequences) {
        return 0;
    }

    @Override
    public long incrementAndGet(int delta, Sequence[] dependentSequences) {
        return 0;
    }

    @Override
    public void setSequence(long sequence, Sequence[] dependentSequences) {

    }

    @Override
    public void serialisePublishing(long sequence, Sequence cursor, int batchSize) {

    }

    @Override
    public long checkAndIncrement(int availableCapacity, int delta, Sequence[] gatingSequences) throws InsufficientCapacityException {
        return 0;
    }
}
