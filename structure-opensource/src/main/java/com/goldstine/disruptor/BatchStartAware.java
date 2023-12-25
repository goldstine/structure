package com.goldstine.disruptor;

public interface BatchStartAware {
    void onBatchStart(long batchSize);
}
