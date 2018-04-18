package org.xenei.recording;

public class LoggingEvent {

    private Level level;
    private String message;
    private Throwable throwable;
    private Object[] args;

    public LoggingEvent(Level level, String message) {
        this.level = level;
        this.message = message;
    }

    public LoggingEvent(Level level, String message, Object... args) {
        this.level = level;
        this.message = message;
        args = args;
    }

    public LoggingEvent(Level level, String message, Throwable throwable) {
        this.level = level;
        this.message = message;
        this.throwable = throwable;
    }
}
