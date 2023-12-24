package com.goldstine.disruptor;

public interface EventTranslator <T>{
    void translateTo(T event,long sequence);
}
