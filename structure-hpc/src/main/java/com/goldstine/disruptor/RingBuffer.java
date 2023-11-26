package com.goldstine.disruptor;



public final class RingBuffer<T> extends Sequencer{

    private final int indexMask;

    private  final Object[] entries;

    public RingBuffer(final EventFactory<T> eventFactory,final ClaimStrategy claimStrategy,final WaitStrategy waitStrategy){
        super(claimStrategy,waitStrategy);

        if(Integer.bitCount(claimStrategy.getBufferSize())!=1){
            throw new IllegalArgumentException("bufferSize must be a power of 2");
        }

        indexMask=claimStrategy.getBufferSize()-1;

        entries=new Object[claimStrategy.getBufferSize()];

        fill(eventFactory);
    }

    public RingBuffer(final EventFactory<T> eventFactory,final int bufferSize){
        this(eventFactory,new MultiThreadedClaimStrategy(bufferSize),new BlockingWaitStrategy());
    }

    public T get(final long sequence){
        return (T)entries[(int)sequence&indexMask];
    }

    private void fill(final EventFactory<T> eventFactory){
        for(int i=0;i<entries.length;i++){
            entries[i]=eventFactory.newInstance();
        }
    }



}
