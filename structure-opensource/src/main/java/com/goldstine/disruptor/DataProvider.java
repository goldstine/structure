package com.goldstine.disruptor;

public interface DataProvider<T> {
    T get(long sequence);
}
