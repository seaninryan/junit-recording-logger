package org.xenei.slf4j.recording;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xenei.log4j.recording.events.StringEvent;
import org.xenei.log4j.recording.selector.MessageContainsSelector;
import org.xeni.slf4j.recording.RecordingLogger;
import org.xeni.slf4j.recording.RecordingLoggerFactory;

import static org.junit.Assert.assertTrue;

public class RecordingAppenderTest {

    private RecordingLogger TEST_LOGGER = RecordingLoggerFactory.getInstance().getLogger("TEST LOGGER");

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {
        TEST_LOGGER.recordedEvents().clear();
    }

    @Test
    public void test_can_record_slf4j_logmessage() {
        // given

        // when
        TEST_LOGGER.warn("Test Log Message");

        // then
        assertTrue(
                TEST_LOGGER.recordedEvents().has(new MessageContainsSelector(),
                        new StringEvent( org.apache.log4j.Level.WARN, "Test Log Message" )));
    }

}
