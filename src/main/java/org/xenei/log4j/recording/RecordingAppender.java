/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xenei.log4j.recording;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Assert;
import org.xenei.log4j.recording.selector.Selector;

/**
 * A logging appender that records the logging events for later testing. Used in
 * junit tests to verify that messages have been written to the log.
 *
 * Tests use a Selector to determine if the logging events are found.
 *
 */
public class RecordingAppender extends AppenderSkeleton {

	// the recorded history.
	private final List<LoggingEvent> history;

	/**
	 * Constructor
	 */
	public RecordingAppender() {
		history = new ArrayList<LoggingEvent>();
	}

	/**
	 * Close the appender.
	 */
	public void close() {
		// do nothing
	}

	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(final LoggingEvent event) {
		history.add(event);
	}

	private final boolean has(final Selector selector,
			final List<LoggingEvent> event1, final List<LoggingEvent> event2) {
		if (event1.size() != event2.size()) {
			return false;
		}
		for (int i = 0; i < event1.size(); i++) {
			if (!selector.matches(event1.get(i), event2.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check that the recorded events contains with the list of events in the
	 * order specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param things
	 *            the list of events to expect.
	 * @return true if the events are found in order.
	 */
	public final boolean has(final Selector selector,
			final List<LoggingEvent> things) {
		return has(selector, things, history);
	}

	/**
	 * Check that the recorded events starts with the list of events in the
	 * order specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param events
	 *            the list of events to expect.
	 * @return true if the events are found in order.
	 */
	public final boolean hasStart(final Selector selector,
			final List<LoggingEvent> events) {
		if (events.size() <= history.size()) {
			return has(selector, events, history.subList(0, events.size()));
		}
		return false;
	}

	/**
	 * Check that the recorded events ends with the list of events in the order
	 * specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param events
	 *            the list of events to expect.
	 * @return true if the events are found in order.
	 */
	public final boolean hasEnd(final Selector selector,
			final List<LoggingEvent> events) {
		if (events.size() <= history.size()) {
			return has(selector, events,
					history.subList(history.size() - events.size(), history.size()));
		}
		return false;
	}

	/**
	 * Assert that the recorded events contains the list of events in the order
	 * specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param events
	 *            the list of events to expect.
	 */
	public final void assertHas(final Selector selector,
			final List<LoggingEvent> events) {
		if (has(selector, events) == false) {
			Assert.fail("expected " + asStrings(events) + " but got " + asStrings(history));
		}
	}
	
	private List<String> asStrings( LoggingEvent... events)
	{
		return asStrings( Arrays.asList(events));
	}
	
	private List<String> asStrings( List<LoggingEvent> events)
	{
		List<String> retval = new ArrayList<String>( events.size() );
		for (LoggingEvent e : events )
		{
			retval.add( e.getMessage().toString());
		}
		return retval;
	}

	/**
	 * Assert that the recorded events contains the list of events in the order
	 * specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param events
	 *            the list of events to expect.
	 */
	public final void assertContains(final Selector selector,
			final LoggingEvent... events) {
		if (contains(selector, events) == false) {
			Assert.fail(String.format( "Did not find %s in the logging history: %s", asStrings( events ), asStrings(history)));
		}
	}

	/**
	 * Assert that the recorded events starts with the list of events in the
	 * order specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param start
	 *            the list of events to expect.
	 */
	public final void assertHasStart(final Selector selector,
			final LoggingEvent... start) {
		final List<LoggingEvent> startList = Arrays.asList(start);
		if (hasStart(selector, startList) == false) {
			Assert.fail("expected " + asStrings(startList) + " at the beginning of " + asStrings(history));
		}
	}

	/**
	 * Assert that the recorded events ends with the list of events in the order
	 * specified without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param end
	 *            the list of events to expect.
	 */
	public final void assertHasEnd(final Selector selector,
			final LoggingEvent... end) {
		final List<LoggingEvent> endList = Arrays.asList(end);
		if (hasEnd(selector, endList) == false) {
			Assert.fail("expected " + asStrings(endList) + " at the end of " + asStrings(history));
		}
	}

	/**
	 * Clear the list of recorded events.
	 *
	 * This allows the appender to be reused.
	 */
	public final void clear() {
		history.clear();
	}

	/**
	 * Return true if the list of events are found in the recorded events in
	 * order without intervening events.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param events
	 *            The list of events to check.
	 * @return True if the events are found in the stored events.
	 */
	public final boolean contains(final Selector selector,
			final LoggingEvent... events) {
		for (int i = 0; i < history.size(); i++) {
			if (selector.matches(history.get(i), events[0])) {
				boolean found = true;
				for (int j = 1; j < events.length; j++) {
					if ((i + j) >= history.size()) {
						found = false;
						break;
					}
					if (!selector.matches(history.get(i + j), events[j])) {
						found = false;
						break;
					}
				}
				if (found) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns an iterator over all the recorded events.
	 * @return the iterator.
	 */
	public final Iterator<LoggingEvent> getEvents()
	{
		return history.iterator();
	}
	
	/**
	 * Returns an iterator over the recorded events following the first instance
	 * of the start event.
	 * 
	 * @param selector
	 *            The selector to use.
	 * @param start
	 *            The starting event.
	 * @return An iterator of the recorded events.
	 */
	public final Iterator<LoggingEvent> from(final Selector selector,
			final LoggingEvent start) {
		final Iterator<LoggingEvent> iter = history.iterator();
		while (iter.hasNext() && (!selector.matches(iter.next(), start))) {
			; // loop
		}
		return iter;
	}

}
