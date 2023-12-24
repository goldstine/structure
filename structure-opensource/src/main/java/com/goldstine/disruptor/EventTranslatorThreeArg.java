package com.goldstine.disruptor;

public interface EventTranslatorThreeArg <T,A,B,C>{
    void translateTo(T event, long sequence, A arg0, B arg1, C arg2);
}
