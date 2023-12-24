package com.goldstine.disruptor;

public interface LifecycleAware {
    void onStart();
    void onShutdown();
}
