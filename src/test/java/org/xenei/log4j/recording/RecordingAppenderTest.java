package org.xenei.log4j.recording;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.xenei.log4j.recording.events.StringEvent;
import org.xenei.log4j.recording.selector.MessageSelector;
import org.xenei.log4j.recording.selector.Selector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

public class RecordingAppenderTest {

	private RecordingAppender recording = new RecordingAppender();
	private Logger log = Logger.getLogger( this.getClass() );
	
	public RecordingAppenderTest() {
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setup() {
		Logger root = Logger.getRootLogger();
		
		root.addAppender( recording );
	}
	
	@After
	public void cleanup() {
		Logger root = Logger.getRootLogger();
		root.removeAppender( recording );
		recording.clear();
	}
	
	@Test
	public void testAdded() {

		log.debug( "debug message");
		log.warn( "warning message");
		log.info( "info message");
		log.error( "error message");
		
		Selector selector = new MessageSelector();
		
		StringEvent event = new StringEvent( "debug message");
		recording.assertContains(selector, event );
		
		event = new StringEvent( "warning message");
		recording.assertContains(selector, event );

		event = new StringEvent( "info message");
		recording.assertContains(selector, event );

		event = new StringEvent( "error message");
		recording.assertContains(selector, event );
		
		recording.clear();
		
		assertFalse(recording.contains(selector, event));
		
	}
	
}
