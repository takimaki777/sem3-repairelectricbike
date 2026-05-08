package se.kth.iv1350.repairelectricbike.integration;

/**
 * Thrown when the customer registry cannot be reached.
 */
public class DatabaseFailureException extends Exception {

    /**
     * Creates a new exception for database failures.
     *
     * @param phone The phone number used when the error occurred.
     */
    public DatabaseFailureException(String phone) {
        super("The customer registry could not be reached when searching for phone number: " + phone);
    }
}