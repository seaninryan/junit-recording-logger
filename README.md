# junit-recording-logger
A log4j logging appender that records the logging events for later testing. 
Used in junit tests to verify that messages have been written to the log.

# example of usage
    // add the recording logger to log4j
    private RecordingAppender recording = new RecordingAppender();
    private Logger log = Logger.getLogger( this.getClass() );
    
   
    // setup
    Logger root = Logger.getRootLogger();
    root.addAppender( recording );
   
   
    // write some log messages
    log.debug( "debug message");
    log.warn( "warning message");
    log.info( "info message");
    log.error( "error message");
    
    // check for presence of messages
    Selector selector = new MessageSelector();
    StringEvent event = new StringEvent( "debug message");
    
    recording.assertContains(selector, event );
    event = new StringEvent( "warning message");
    recording.assertContains(selector, event );
    event = new StringEvent( "info message");
    recording.assertContains(selector, event );
    event = new StringEvent( "error message");
    recording.assertContains(selector, event );
    
    // clear the recordings for the next test
    recording.clear();
   
    // more tests here
   
    // remove the logger - probably not necessary in a standard test
    Logger root = Logger.getRootLogger();
    root.removeAppender( recording );
    recording.close();
   
