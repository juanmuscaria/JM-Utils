package io.github.juanmuscaria.jmutils.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LightScheduler {
    private final AtomicInteger ids = new AtomicInteger(1);
    private Executor executor;
    private ConcurrentLinkedQueue<FeatherTask> asyncPending;
    private SynchronousQueue<FeatherTask> syncPending;

    private long tick = 0;

    public LightScheduler() {
        executor = Executors.newCachedThreadPool();

    }

    public void mainThreadTick() {
    }
}
