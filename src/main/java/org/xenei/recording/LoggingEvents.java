package org.xenei.recording;

import org.xenei.log4j.recording.selector.Selector;

import java.util.ArrayList;
import java.util.List;

public class LoggingEvents {

    private List<LoggingEvent> recordedEvents = new ArrayList<LoggingEvent>();

    public void clear() {
        recordedEvents.clear();
    }

    public void add(LoggingEvent loggingEvent) {
        recordedEvents.add(loggingEvent);
    }

    public final boolean has(final Selector selector,
                             final List<LoggingEvent> things) {
        return has(selector, recordedEvents, things);
    }

    private final boolean has(final Selector selector,
                              final List<LoggingEvent> list1, final List<LoggingEvent> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!selector.matches(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
