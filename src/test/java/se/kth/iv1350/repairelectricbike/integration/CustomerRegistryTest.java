package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.CustomerNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the CustomerRegistry class.
 */
public class CustomerRegistryTest {

    /**
     * Tests that a created customer can be found.
     */
    @Test
    public void createdCustomerShouldBeFound()
            throws CustomerNotFoundException, DatabaseFailureException {
        CustomerRegistry customerRegistry = new CustomerRegistry();

        customerRegistry.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        CustomerDTO foundCustomer = customerRegistry.findCustomer("0701234567");

        assertNotNull(foundCustomer);
        assertEquals("0701234567", foundCustomer.getPhone());
    }

    /**
     * Tests that an exception is thrown when a customer does not exist.
     */
    @Test
    public void missingCustomerShouldThrowCustomerNotFoundException() {
        CustomerRegistry customerRegistry = new CustomerRegistry();

        assertThrows(CustomerNotFoundException.class, () -> {
            customerRegistry.findCustomer("0000000000");
        });
    }

    /**
     * Tests that an exception is thrown during a simulated database failure.
     */
    @Test
    public void databaseFailureShouldThrowDatabaseFailureException() {
        CustomerRegistry customerRegistry = new CustomerRegistry();

        assertThrows(DatabaseFailureException.class, () -> {
            customerRegistry.findCustomer("9999999999");
        });
    }
}