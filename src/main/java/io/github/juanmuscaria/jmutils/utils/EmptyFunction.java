package io.github.juanmuscaria.jmutils.utils;

/**
 * Use this function to save some lines when not using cache calls.
 *
 * @author juanmuscaria
 */
public class EmptyFunction<V> extends Function<V> {
    @Override
    public boolean run(V value) {
        return false;
    }
}
