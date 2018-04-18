package org.xeni.slf4j.recording;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.xenei.recording.Level;
import org.xenei.recording.LoggingEvent;
import org.xenei.recording.LoggingEvents;

public class RecordingLogger implements Logger {

    private Level level;
    private String name;
    private LoggingEvents recordedEvents = new LoggingEvents();

    public RecordingLogger(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public LoggingEvents recordedEvents() {
        return recordedEvents;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTraceEnabled() {
        return Level.TRACE.compareTo(level) <= 0;
    }

    @Override
    public void trace(String message) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message));
        }
    }

    @Override
    public void trace(String message, Object arg) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, arg));
        }
    }

    @Override
    public void trace(String message, Object arg, Object arg1) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, arg, arg1));
        }
    }

    @Override
    public void trace(String message, Object... args) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, args));
        }
    }

    @Override
    public void trace(String message, Throwable throwable) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, throwable));
        }
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String message) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message));
        }
    }

    @Override
    public void trace(Marker marker, String message, Object arg) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, arg));
        }
    }

    @Override
    public void trace(Marker marker, String message, Object arg, Object arg1) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, arg, arg1));
        }
    }

    @Override
    public void trace(Marker marker, String message, Object... args) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, args));
        }
    }

    @Override
    public void trace(Marker marker, String message, Throwable throwable) {
        if (isTraceEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.TRACE, message, throwable));
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return Level.DEBUG.compareTo(level) <= 0;
    }

    @Override
    public void debug(String message) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message));
        }
    }

    @Override
    public void debug(String message, Object arg) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, arg));
        }
    }

    @Override
    public void debug(String message, Object arg, Object arg1) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, arg, arg1));
        }
    }

    @Override
    public void debug(String message, Object... args) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, args));
        }
    }

    @Override
    public void debug(String message, Throwable throwable) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, throwable));
        }
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String message) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message));
        }
    }

    @Override
    public void debug(Marker marker, String message, Object arg) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, arg));
        }
    }

    @Override
    public void debug(Marker marker, String message, Object arg, Object arg1) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, arg, arg1));
        }
    }

    @Override
    public void debug(Marker marker, String message, Object... args) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, args));
        }
    }

    @Override
    public void debug(Marker marker, String message, Throwable throwable) {
        if (isDebugEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.DEBUG, message, throwable));
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return Level.INFO.compareTo(level) <= 0;
    }

    @Override
    public void info(String message) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message));
        }
    }

    @Override
    public void info(String message, Object arg) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, arg));
        }
    }

    @Override
    public void info(String message, Object arg, Object arg1) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, arg, arg1));
        }
    }

    @Override
    public void info(String message, Object... args) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, args));
        }
    }

    @Override
    public void info(String message, Throwable throwable) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, throwable));
        }
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String message) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message));
        }
    }

    @Override
    public void info(Marker marker, String message, Object arg) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, arg));
        }
    }

    @Override
    public void info(Marker marker, String message, Object arg, Object arg1) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, arg, arg1));
        }
    }

    @Override
    public void info(Marker marker, String message, Object... args) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, args));
        }
    }

    @Override
    public void info(Marker marker, String message, Throwable throwable) {
        if (isInfoEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.INFO, message, throwable));
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return Level.WARN.compareTo(level) <= 0;
    }

    @Override
    public void warn(String message) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message));
        }
    }

    @Override
    public void warn(String message, Object arg) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, arg));
        }
    }

    @Override
    public void warn(String message, Object... args) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, args));
        }
    }

    @Override
    public void warn(String message, Object arg, Object arg1) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, arg, arg1));
        }
    }

    @Override
    public void warn(String message, Throwable throwable) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, throwable));
        }
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String message) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message));
        }
    }

    @Override
    public void warn(Marker marker, String message, Object arg) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, arg));
        }
    }

    @Override
    public void warn(Marker marker, String message, Object arg, Object arg1) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, arg, arg1));
        }
    }

    @Override
    public void warn(Marker marker, String message, Object... args) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, args));
        }
    }

    @Override
    public void warn(Marker marker, String message, Throwable throwable) {
        if (isWarnEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.WARN, message, throwable));
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return Level.ERROR.compareTo(level) <= 0;
    }

    @Override
    public void error(String message) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message));
        }
    }

    @Override
    public void error(String message, Object arg) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, arg));
        }
    }

    @Override
    public void error(String message, Object arg, Object arg1) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, arg, arg1));
        }
    }

    @Override
    public void error(String message, Object... args) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, args));
        }
    }

    @Override
    public void error(String message, Throwable throwable) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, throwable));
        }
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String message) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message));
        }
    }

    @Override
    public void error(Marker marker, String message, Object arg) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, arg));
        }
    }

    @Override
    public void error(Marker marker, String message, Object arg, Object arg1) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, arg, arg1));
        }
    }

    @Override
    public void error(Marker marker, String message, Object... args) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, args));
        }
    }

    @Override
    public void error(Marker marker, String message, Throwable throwable) {
        if (isErrorEnabled()) {
            recordedEvents.add(new LoggingEvent(Level.ERROR, message, throwable));
        }
    }
}
