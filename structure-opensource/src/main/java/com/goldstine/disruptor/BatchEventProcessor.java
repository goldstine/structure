package com.goldstine.disruptor;

import java.util.concurrent.atomic.AtomicInteger;

public final class BatchEventProcessor<T> implements EventProcessor{

    private static final int IDLE=0;

    private static final int HALTED=IDLE+1;

    private static final int RUNNING=HALTED+1;

    private final AtomicInteger running=new AtomicInteger(IDLE);

    private ExceptionHandler<? super T> exceptionHandler=new FatalExceptionHandler();



    @Override
    public Sequence getSequence() {
        return null;
    }

    @Override
    public void halt() {

    }

    @Override
    public boolean isRunnning() {
        return false;
    }

    @Override
    public void run() {

    }
}
