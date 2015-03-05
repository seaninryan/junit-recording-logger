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
