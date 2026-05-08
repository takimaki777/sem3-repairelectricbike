package se.kth.iv1350.repairelectricbike.model;

/**
 * Thrown when a customer does not exist in the customer registry.
 */
public class CustomerNotFoundException extends Exception {

    /**
     * Creates a new exception for a missing customer.
     *
     * @param phone The phone number that could not be found.
     */
    public CustomerNotFoundException(String phone) {
        super("No customer was found with phone number: " + phone);
    }
}