package io.github.juanmuscaria.jmutils.utils;

public abstract class WrappedLogger {
    private LogLevel level = LogLevel.INFO;

    public abstract void fatal(String message);

    public abstract void error(String message);

    public abstract void warn(String message);

    public abstract void info(String message);

    public abstract void debug(String message);

    public abstract void trace(String message);

    protected boolean isLoggable(LogLevel level) {
        return this.level.getLevel() >= level.getLevel();
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public enum LogLevel {
        NONE(0),
        FATAL(1),
        ERROR(2),
        WARN(3),
        INFO(4),
        DEBUG(5),
        TRACE(6);

        private int level;

        LogLevel(int level) {
            this.level = level;
        }

        public static LogLevel valueOf(int level) {
            try {
                return LogLevel.values()[level];
            } catch (ArrayIndexOutOfBoundsException e) {
                return LogLevel.INFO;
            }
        }

        public int getLevel() {
            return level;
        }
    }

    public static class PrinterLogger extends WrappedLogger {
        private final String name;

        public PrinterLogger(String name) {
            this.name = name;
        }

        @Override
        public void fatal(String message) {
            if (isLoggable(LogLevel.FATAL)) System.out.println("[" + name + "-FATAL] " + message);
        }

        @Override
        public void error(String message) {
            if (isLoggable(LogLevel.ERROR)) System.out.println("[" + name + "-ERROR] " + message);
        }

        @Override
        public void warn(String message) {
            if (isLoggable(LogLevel.WARN)) System.out.println("[" + name + "-WARNING] " + message);
        }

        @Override
        public void info(String message) {
            if (isLoggable(LogLevel.INFO)) System.out.println("[" + name + "-INFO] " + message);
        }

        @Override
        public void debug(String message) {
            if (isLoggable(LogLevel.DEBUG)) System.out.println("[" + name + "-DEBUG] " + message);
        }

        @Override
        public void trace(String message) {
            if (isLoggable(LogLevel.TRACE)) System.out.println("[" + name + "-TRACE] " + message);
        }

    }
}
