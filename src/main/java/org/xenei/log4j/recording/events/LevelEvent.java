/**
 * Licensed Materials - Property of IBM
 * "Restricted Materials of IBM"
 * 5725-F56 (c) Copyright IBM and others 2002, 2012
 * IBM Tivoli Netcool Configuration Manager
 */

package org.xenei.log4j.recording.events;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/**
 * An event that contains a specific level. 
 *
 */
public class LevelEvent extends LoggingEvent {

    private static final long serialVersionUID = 2223542670256070450L;

    /**
     * Constructor.
     * @param level The event to match.
     */
    public LevelEvent(Level level) {
        super(LevelEvent.class.getCanonicalName(),
                Logger.getLogger(LevelEvent.class.getCanonicalName()),
                level, "", null);
    }

}
