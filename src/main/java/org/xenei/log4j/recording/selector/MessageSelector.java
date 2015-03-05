package org.xenei.log4j.recording.selector;

import org.apache.log4j.spi.LoggingEvent;

/**
 * matches if rendered messages are compared with respect to case.
 *
 */
public class MessageSelector implements Selector {

	/**
	 * Returns true if the first event equals the rendered message from the second event.
	 */
	public boolean matches(final LoggingEvent event1, final LoggingEvent event2) {
		return event1.getRenderedMessage().equals(event2.getRenderedMessage());
	}

}
