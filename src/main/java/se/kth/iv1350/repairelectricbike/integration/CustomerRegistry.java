package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;

/**
 * Stores customers (simulates a database).
 */
public class CustomerRegistry {
    private List<CustomerDTO> customers = new ArrayList<>();

    /**
     * Creates a new customer and stores it.
     *
     * @param name The customer's name.
     * @param phone The customer's phone number.
     * @param email The customer's email.
     * @param bikeModel The bike model.
     * @param bikeBrand The bike brand.
     * @param bikeSerialNumber The bike serial number.
     * @return The created customer.
     */
    public CustomerDTO createCustomer(String name, String phone, String email,
                                      String bikeModel, String bikeBrand, String bikeSerialNumber) {

        CustomerDTO customer = new CustomerDTO(name, phone, email,
                bikeModel, bikeBrand, bikeSerialNumber);

        customers.add(customer);

        return customer;
    }

    /**
     * Finds a customer by phone number.
     *
     * @param phone The customer's phone number.
     * @return The found customer, or null if not found.
     */
    public CustomerDTO findCustomer(String phone) {
        for (CustomerDTO customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }
}