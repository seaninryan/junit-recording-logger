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
 * Selects if the captured thrown object is assignable from the expected type.
 *
 */
public class ThrowableSelector implements Selector {

    @Override
    public boolean matches(LoggingEvent event1, LoggingEvent event2) {
        ThrowableInformation ti1 = event1.getThrowableInformation();
        ThrowableInformation ti2 = event2.getThrowableInformation();

        if (ti1 == null || ti2 == null) {
            return false;
        }
        return ti2.getThrowable().getClass().isAssignableFrom(
                ti1.getThrowable().getClass());
    }

}
