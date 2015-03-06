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
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/**
 * A LoggingEvent that can be used to record a string for comparing.
 *
 */
public class StringEvent extends LoggingEvent {


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
		return StringEvent.class.getCanonicalName();
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
	public StringEvent(final String fqnOfCategoryClass, final Category logger,
			final Priority level, final String message,
			final Throwable throwable) {
		super(fqnOfCategoryClass, logger, level, message, throwable);
	}

	/**
	 * Create a string event with the specified message. fqnOfCategoryClass
	 * defaults to getCategoryClass(). logger defaults to getCategory(). level
	 * defaults to DEBUG. throwable defaults to null.
	 * 
	 * @param message
	 *            The message.
	 */
	public StringEvent(final String message) {
		this(Priority.DEBUG, message);
	}

	/**
	 * Create a string event with the specified level and message.
	 * fqnOfCategoryClass defaults to getCategoryClass(). logger defaults to
	 * getCategory(). throwable defaults to null.
	 * 
	 * @param level
	 *            The priority.
	 * @param message
	 *            The message.
	 */
	public StringEvent(final Priority level, final String message) {
		this(getCategoryClass(), getCategory(), level, message, null);
	}

	/**
	 * Create a string event with the specified fqnOfCategoryClass, level and
	 * message.
	 *
	 * logger defaults to fqnOfCategoryClass throwable defaults to null.
	 * 
	 * @param fqnOfCategoryClass
	 *            the category class.
	 * @param level
	 *            The priority.
	 * @param message
	 *            The message.
	 */
	public StringEvent(final String fqnOfCategoryClass, final Priority level,
			final String message) {
		this(fqnOfCategoryClass, Category.getInstance(fqnOfCategoryClass),
				level, message, null);
	}
}
