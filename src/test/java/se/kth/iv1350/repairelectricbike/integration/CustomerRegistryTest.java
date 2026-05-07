package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerRegistryTest {

    @Test
    public void createCustomerShouldReturnCustomerDTO() {
        CustomerRegistry registry = new CustomerRegistry();

        CustomerDTO customer = registry.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        assertNotNull(customer);
        assertEquals("Sven Svensson", customer.getName());
        assertEquals("0701234567", customer.getPhone());
    }

    @Test
    public void findExistingCustomerShouldReturnCustomer() {
        CustomerRegistry registry = new CustomerRegistry();

        registry.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        CustomerDTO foundCustomer = registry.findCustomer("0701234567");

        assertNotNull(foundCustomer);
        assertEquals("Sven Svensson", foundCustomer.getName());
        assertEquals("0701234567", foundCustomer.getPhone());
    }

    @Test
    public void findUnknownCustomerShouldReturnNull() {
        CustomerRegistry registry = new CustomerRegistry();

        CustomerDTO foundCustomer = registry.findCustomer("0000000000");

        assertNull(foundCustomer);
    }
}