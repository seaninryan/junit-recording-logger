package org.xenei.log4j.recording.selector;

import org.apache.log4j.spi.LoggingEvent;

/**
 * Determine if a logging event matches a second logging event.
 * 
 * The definition of "match" is determined by the implementation.
 *
 */
public interface Selector {
	/**
	 * Return true if the events match.
	 * @param event1 The first logging event.
	 * @param o2 the second logging event.
	 * @return true if the events match.
	 */
	public boolean matches(LoggingEvent event1, LoggingEvent o2);
}
