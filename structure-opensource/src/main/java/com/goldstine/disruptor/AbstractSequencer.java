package com.goldstine.disruptor;

import com.goldstine.disruptor.util.Util;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class AbstractSequencer implements Sequencer {
    private static final AtomicReferenceFieldUpdater<AbstractSequencer,Sequence[]> SEQUENCE_UPDATER=
            AtomicReferenceFieldUpdater.newUpdater(AbstractSequencer.class,Sequence[].class,"gatingSequences");

    protected final int bufferSize;
    protected final WaitStrategy waitStrategy;
    protected final Sequence cursor=new Sequence(Sequencer.INITIAL_CURSOR_VALUE);
    protected volatile Sequence[] gatingSequences=new Sequence[0];

    public AbstractSequencer(int bufferSize,WaitStrategy waitStrategy){
        if (bufferSize < 1) {
            throw new IllegalArgumentException("bufferSize must not be less than 1");
        }
        if (Integer.bitCount(bufferSize) != 1) {
            throw new IllegalArgumentException("bufferSize must be a power of 2");
        }
        this.bufferSize=bufferSize;
        this.waitStrategy=waitStrategy;
    }

    @Override
    public final long getCursor(){
        return cursor.get();
    }

    public int getBufferSize() {
        return bufferSize;
    }

    @Override
    public void addGetingSequence(Sequence... gatingSequences) {
        SequenceGroups.addSequences(this,SEQUENCE_UPDATER,this,gatingSequences);
    }

    public Sequence[] getGatingSequences() {
        return gatingSequences;
    }

    @Override
    public <T> EventPoller<T> newPoller(DataProvider<T> dataProvider, Sequence... gatingSequences) {
        return EventPoller.newInstance(dataProvider,this,new Sequence(),cursor,gatingSequences);
    }

    @Override
    public boolean removeGatingSequence(Sequence sequence) {
        return SequenceGroups.removeSequence(this,SEQUENCE_UPDATER,sequence);
    }

    @Override
    public SequenceBarrier newBarrier(Sequence... sequencesTrack) {
        return new ProcessingSequenceBarrier(this,waitStrategy,cursor,sequencesTrack);
    }

    @Override
    public long getMinimumSequence() {
        return Util.getMinimumSequence(gatingSequences,cursor.get());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
