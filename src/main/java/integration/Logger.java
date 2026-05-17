package integration;

/**
 * A logger interface for logging data in different ways. Any class that wants to logg shall implement this class.
 */
public interface Logger {
    /**
     * 
     * @param message is the message that will be logged.
     */
    void log(String message);
}
