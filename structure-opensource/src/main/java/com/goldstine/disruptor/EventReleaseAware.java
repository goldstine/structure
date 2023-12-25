package com.goldstine.disruptor;

public interface EventReleaseAware {
    void setEventReleaser(EventReleaser eventReleaser);
}
