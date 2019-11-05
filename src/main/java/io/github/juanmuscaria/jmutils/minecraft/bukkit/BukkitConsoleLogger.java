package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import io.github.juanmuscaria.jmutils.utils.WrappedLogger;

import java.util.logging.Logger;

public class BukkitConsoleLogger extends WrappedLogger {
    private final Logger logger;

    public BukkitConsoleLogger(Logger pluginLogger) {
        logger = pluginLogger;
    }

    @Override
    public void fatal(String message) {
        if (isLoggable(LogLevel.FATAL)) logger.severe(" [FATAL] " + message);
    }

    @Override
    public void error(String message) {
        if (isLoggable(LogLevel.ERROR)) logger.severe(message);
    }

    @Override
    public void warn(String message) {
        if (isLoggable(LogLevel.WARN)) logger.warning(message);
    }

    @Override
    public void info(String message) {
        if (isLoggable(LogLevel.INFO)) logger.info(message);
    }

    @Override
    public void debug(String message) {
        if (isLoggable(LogLevel.DEBUG)) logger.info(" [DEBUG] " + message);
    }

    @Override
    public void trace(String message) {
        if (isLoggable(LogLevel.TRACE)) logger.info(" [TRACE] " + message);
    }
}
