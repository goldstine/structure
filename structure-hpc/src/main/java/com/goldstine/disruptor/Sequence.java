package com.goldstine.disruptor;

import com.goldstine.disruptor.util.Util;
import sun.misc.Unsafe;

public class Sequence {
    private static final Unsafe unsafe;
    private static final long valueOffset;

    static {
        unsafe= Util.getUnsafe();
        final int base = unsafe.arrayBaseOffset(long[].class);
        final int scale = unsafe.arrayIndexScale(long[].class);
        valueOffset = base + (scale * 7);
    }

    private final long[] paddedValue=new long[15];
    public Sequence(){
        setOrdered(-1);
    }

    public Sequence(final long initialValue){
        setOrdered(initialValue);
    }

    private void setOrdered(final long value){
        unsafe.putOrderedLong(paddedValue,valueOffset,value);
    }

    public long get(){
        return unsafe.getLongVolatile(paddedValue,valueOffset);
    }

    public void set(final long value){
        unsafe.putOrderedLong(paddedValue,valueOffset,value);
    }

    public boolean compareAndSet(final long expectedValue,final long newValue){
        return unsafe.compareAndSwapLong(paddedValue,valueOffset,expectedValue,newValue);
    }

    public String toString(){
        return Long.toString(get());
    }

    public long incrementAndGet(){
        return addAndGet(1L);
    }

    public long addAndGet(final long increment){
        long currentValue;
        long newValue;
        do{
            currentValue=get();
            newValue=currentValue+increment;
        }while(!compareAndSet(currentValue,newValue));
        return newValue;
    }

}
