package com.goldstine.disruptor.dsl;

import com.goldstine.disruptor.ExceptionHandler;
import com.goldstine.disruptor.FatalExceptionHandler;

public class ExceptionHandlerWrapper <T> implements ExceptionHandler<T> {

    private ExceptionHandler<? super T> delegate =new FatalExceptionHandler();

    public void switchTo(final ExceptionHandler<? super T> exceptionHandler){
        this.delegate=exceptionHandler;
    }

    @Override
    public void handleEventException(final Throwable ex, final long sequence, final T event) {
        delegate.handleEventException(ex,sequence,event);
    }

    @Override
    public void handlerOnStartException(final Throwable ex) {
        delegate.handlerOnStartException(ex);
    }

    @Override
    public void handlerOnShutdownException(final Throwable ex) {
        delegate.handlerOnShutdownException(ex);
    }
}
