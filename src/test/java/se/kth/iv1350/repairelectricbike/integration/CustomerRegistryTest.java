package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;

/**
 * Testar klassen CustomerRegistry.
 */
public class CustomerRegistryTest {
    /**
     * Testar att en skapad kund kan hittas.
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
                "Den hittade kunden ska vara samma som den skapade kunden.");
    }

    /**
     * Testar att null returneras när ingen kund hittas.
     */
    @Test
    public void testFindCustomerThatDoesNotExist() {
        CustomerRegistry registry = new CustomerRegistry();

        CustomerDTO foundCustomer = registry.findCustomer("0000000000");

        assertNull(foundCustomer,
                "Ingen kund ska hittas när telefonnumret inte finns.");
    }
}