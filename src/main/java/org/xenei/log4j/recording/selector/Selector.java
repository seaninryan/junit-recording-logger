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
