package com.goldstine.disruptor.dsl;

import com.goldstine.disruptor.EventHandler;

import java.util.IdentityHashMap;

public class ConsumerRepository<T> {
    private final Map<EventHandler<?>,EventProcessorInfo<T>> eventProcessorInfoByEventHandler=new IdentityHashMap<>();


}
