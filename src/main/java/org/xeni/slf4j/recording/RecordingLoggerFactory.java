package org.xeni.slf4j.recording;

import org.slf4j.ILoggerFactory;
import org.xenei.recording.Level;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RecordingLoggerFactory implements ILoggerFactory {
    private static final RecordingLoggerFactory INSTANCE = new RecordingLoggerFactory();
    ConcurrentMap<String, RecordingLogger> loggerMap = new ConcurrentHashMap();

    private RecordingLoggerFactory() {
    }

    public static RecordingLoggerFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public RecordingLogger getLogger(String name) {
        if (!loggerMap.containsKey(name)) {
            RecordingLogger logger = new RecordingLogger(Level.TRACE, name);
            loggerMap.put(name, logger);
        }
        return loggerMap.get(name);
    }
}
