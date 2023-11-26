package com.goldstine.disruptor;

public class Sequencer {

    public static final long INITIAL_CURSOR_VALUE = -1L;

    private final ClaimStrategy claimStrategy;
    private final WaitStrategy waitStrategy;

    public Sequencer(final ClaimStrategy claimStrategy, final WaitStrategy waitStrategy)
    {
        this.claimStrategy = claimStrategy;
        this.waitStrategy = waitStrategy;
    }
}
