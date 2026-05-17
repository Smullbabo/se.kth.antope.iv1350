package integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private PrintWriter logStream;




    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("Cannot log!");
            ioe.printStackTrace();
        }
    }



    public void log(String message) {
        logStream.println(message);
    }
}
