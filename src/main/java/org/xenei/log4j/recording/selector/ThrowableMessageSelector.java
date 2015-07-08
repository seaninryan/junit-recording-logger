/**
 * Licensed Materials - Property of IBM
 * "Restricted Materials of IBM"
 * 5725-F56 (c) Copyright IBM and others 2002, 2012
 * IBM Tivoli Netcool Configuration Manager
 */

package org.xenei.log4j.recording.selector;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

/**
 * Matches the message of a selector.
 * 
 * Both logging events must have throwable objects and the messages must be equal.
 * 
 *
 */
public class ThrowableMessageSelector implements Selector {
	private boolean exactMatch;
	/**
	 * Constructor.
	 * String must match exactly.
	 */
	public ThrowableMessageSelector()
	{
		this(true);
	}

	/**
	 * Constructor.
	 * @param exactMatch if true the string must match exactly otherwis ignore case.
	 */
	public ThrowableMessageSelector(boolean exactMatch)
	{
		this.exactMatch = exactMatch;
	}
	
    @Override
    public boolean matches(LoggingEvent event1, LoggingEvent event2) {
        ThrowableInformation ti1 = event1.getThrowableInformation();
        ThrowableInformation ti2 = event2.getThrowableInformation();

        if (ti1 == null || ti2 == null) {
            return false;
        }
        if (exactMatch)
        {
        	return ti2.getThrowable().getMessage().equals(
                    ti1.getThrowable().getMessage());
        }
        return ti2.getThrowable().getMessage().equalsIgnoreCase(
                ti1.getThrowable().getMessage());
    }

}
