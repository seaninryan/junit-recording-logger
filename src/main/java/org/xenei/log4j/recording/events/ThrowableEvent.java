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

package org.xenei.log4j.recording.events;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/**
 * A LoggingEvent to to capture the throwable.
 *
 */
public class ThrowableEvent extends LoggingEvent {

    /**
     *
     */
    private static final long serialVersionUID = 456232220834660501L;

    /**
     * Get the category name for the default category of this LoggingEvent.
     *
     * @return the category name.
     */
    public static String getCategoryClass() {
        return ThrowableEvent.class.getCanonicalName();
    }

    /**
     * Get the category for the default category of this LoggingEvent.
     *
     * @return The category.
     */
    public static Category getCategory() {
        return Category.getInstance(getCategoryClass());
    }

    /**
     * Create an event.
     *
     * @param fqnOfCategoryClass
     *            the class name of the category.
     * @param logger
     *            The logger category.
     * @param level
     *            the level of the message.
     * @param message
     *            The message.
     * @param throwable
     *            the exception that caused the message to be logged.
     */
    public ThrowableEvent(final String fqnOfCategoryClass,
            final Category logger, final Priority level, final String message,
            final Throwable throwable) {
        super(fqnOfCategoryClass, logger, level, message, throwable);
    }

    /**
     * Create a throwable event that matches only the throwable.
     * Assumes the DEBUG level.
     *
     * @param throwable
     *            The throwable to match.
     */
    public ThrowableEvent(final Throwable throwable) {
        this(Level.DEBUG, "", throwable);
    }

    /**
     * Create a throwable event at a specified level.
     * @param level The level to match
     * @param throwable The throwable to match.
     */
    public ThrowableEvent(final Priority level, Throwable throwable) {
        this(getCategoryClass(), getCategory(), level, "", throwable);
    }

    /**
     * Create a throwable with a specified level, message and throwable.
     * @param level The level to match.
     * @param message The message to match.
     * @param throwable The throwable to match.
     */
    public ThrowableEvent(final Priority level, final String message,
            Throwable throwable) {
        this(getCategoryClass(), getCategory(), level, message, throwable);
    }

    /**
     * Create a throwable with a category class, level, message and throwable.
     * @param fqnOfCategoryClass the category class to match.
     * @param level the level to match.
     * @param message the message to match.
     * @param throwable the throwable to match.
     */
    public ThrowableEvent(final String fqnOfCategoryClass,
            final Priority level, final String message, Throwable throwable) {
        this(fqnOfCategoryClass, Category.getInstance(fqnOfCategoryClass),
                level, message, throwable);
    }
}
