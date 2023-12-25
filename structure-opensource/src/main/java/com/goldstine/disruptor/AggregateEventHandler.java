package com.goldstine.disruptor;

public class AggregateEventHandler <T> implements EventHandler<T>,LifecycleAware{

    private final EventHandler<T>[] eventHandlers;

    public AggregateEventHandler(final EventHandler<T>... eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void onEvent(T event, long sequence, boolean endOfBatch) throws Exception {
        for(final EventHandler<T> eventHandler:eventHandlers){
            eventHandler.onEvent(event,sequence,endOfBatch);
        }
    }

    @Override
    public void onStart() {
        for (final EventHandler<T> eventHandler:eventHandlers){
            if (eventHandler instanceof LifecycleAware) {
                ((LifecycleAware) eventHandler).onStart();
            }
        }
    }

    @Override
    public void onShutdown() {
        for (final EventHandler<T> eventHandler:eventHandlers){
            if (eventHandler instanceof LifecycleAware) {
                ((LifecycleAware) eventHandler).onShutdown();
            }
        }
    }
}
