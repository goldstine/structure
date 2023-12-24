package com.goldstine.disruptor;

public interface EventFactory<T> {
    T newInstance();
}
