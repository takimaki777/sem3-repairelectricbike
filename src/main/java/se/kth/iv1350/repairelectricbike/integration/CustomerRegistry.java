package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.CustomerNotFoundException;

/**
 * Stores customers and simulates a database.
 */
public class CustomerRegistry {
    private static final String DATABASE_FAILURE_PHONE = "9999999999";
    private List<CustomerDTO> customers = new ArrayList<>();

    /**
     * Creates and stores a new customer.
     *
     * @param name The customer's name.
     * @param phone The customer's phone number.
     * @param email The customer's email address.
     * @param bikeModel The bike model.
     * @param bikeBrand The bike brand.
     * @param bikeSerialNumber The bike serial number.
     * @return The created customer.
     */
    public CustomerDTO createCustomer(String name, String phone, String email,
                                      String bikeModel, String bikeBrand,
                                      String bikeSerialNumber) {
        CustomerDTO customer = new CustomerDTO(name, phone, email, bikeModel,
                bikeBrand, bikeSerialNumber);
        customers.add(customer);
        return customer;
    }

    /**
     * Finds a customer using a phone number.
     *
     * @param phone The customer's phone number.
     * @return The found customer.
     * @throws CustomerNotFoundException If the customer does not exist.
     * @throws DatabaseFailureException If the customer registry cannot be reached.
     */
    public CustomerDTO findCustomer(String phone)
            throws CustomerNotFoundException, DatabaseFailureException {
        if (DATABASE_FAILURE_PHONE.equals(phone)) {
            throw new DatabaseFailureException(phone);
        }

        for (CustomerDTO customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }

        throw new CustomerNotFoundException(phone);
    }
}