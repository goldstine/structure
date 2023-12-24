package com.goldstine.disruptor;

public interface ExceptionHandler <T>{
    void handleEventException(Throwable ex,long sequence,T event);

    void handlerOnStartException(Throwable ex);

    void handlerOnShutdownException(Throwable ex);
}
