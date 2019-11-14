package io.github.juanmuscaria.jmutils.concurrent;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class FeatherFutureTask<T> extends FeatherTask implements Future<T> {
    private Callable<T> callable;

    public FeatherFutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean cancel(boolean b) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public T get(long l, @NotNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
