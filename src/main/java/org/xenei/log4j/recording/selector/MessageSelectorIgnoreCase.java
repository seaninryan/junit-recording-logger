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

package org.xenei.log4j.recording.selector;

import org.apache.log4j.spi.LoggingEvent;

/**
 * matches if rendered messages are compared with respect to case.
 *
 */
public class MessageSelectorIgnoreCase implements Selector {

	/**
	 * Returns true if the first event equals the rendered message from the second event
	 * without respect to case.
	 */
	public boolean matches(final LoggingEvent event1, final LoggingEvent event2) {
		return event1.getRenderedMessage()
				.equalsIgnoreCase(event2.getRenderedMessage());
	}
}
