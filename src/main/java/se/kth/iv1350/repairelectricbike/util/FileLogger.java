package se.kth.iv1350.repairelectricbike.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writes log messages to a file.
 */
public class FileLogger {
    private static final String LOG_FILE_NAME = "repairelectricbike-log.txt";

    /**
     * Writes a message to the log file.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.println(message);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}