package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.xeni.slf4j.recording.RecordingLoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return RecordingLoggerFactory.getInstance();
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return RecordingLoggerFactory.class.getName();
    }
}
