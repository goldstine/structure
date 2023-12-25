package com.goldstine.disruptor;

public interface Sequencer extends Cursored,Sequenced{
    long INITIAL_CURSOR_VALUE=-1L;

    void claim(long sequence);

    boolean isAvailable(long sequence);

    void addGetingSequence(Sequence... gatingSequences);

    boolean removeGatingSequence(Sequence sequence);

    SequenceBarrier newBarrier(Sequence... sequencesTrack);

    long getMinimumSequence();

    long getHighestPublishedSequence(long nextSequence, long availableSequence);

    <T> EventPoller<T> newPoller(DataProvider<T> provider,Sequence... gatingSequences);
}
