package integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logger implmenting the logger interface. Logs inputs to the "System_log.txt" file.
 */
public class LoggerToFile implements Logger {
    private PrintWriter logWriter;



    /**
     *  Creates a logger that can write to the log file.
     * 
     * @throws IOException when it cannot write to log.
     */
    public LoggerToFile() {
        try {
            logWriter = new PrintWriter(new FileWriter("System_log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("Cannot log!");
            ioe.printStackTrace();
        }
    }



    /**
     * Logs the specified message to the log file.
     * 
     * @param message is the String to be logged.
     */
    public void log(String message) {
        logWriter.println(message);
    }
}
