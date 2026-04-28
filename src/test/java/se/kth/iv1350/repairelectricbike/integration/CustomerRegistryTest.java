package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;

/**
 * Tests the CustomerRegistry class.
 */
public class CustomerRegistryTest {
    /**
     * Tests that a created customer can be found.
     */
    @Test
    public void testFindCreatedCustomer() {
        CustomerRegistry registry = new CustomerRegistry();

        CustomerDTO createdCustomer = registry.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        CustomerDTO foundCustomer = registry.findCustomer("0701234567");

        assertEquals(createdCustomer, foundCustomer,
                "The found customer should be the same customer that was created.");
    }

    /**
     * Tests that null is returned when no customer is found.
     */
    @Test
    public void testFindCustomerThatDoesNotExist() {
        CustomerRegistry registry = new CustomerRegistry();

        CustomerDTO foundCustomer = registry.findCustomer("0000000000");

        assertNull(foundCustomer,
                "No customer should be found when the phone number does not exist.");
    }
}