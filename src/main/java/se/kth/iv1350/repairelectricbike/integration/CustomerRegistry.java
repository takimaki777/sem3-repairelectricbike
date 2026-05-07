package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.Customer;


/**
 * Lagrar kunder (simulerar en databas).
 */
public class CustomerRegistry {
    private List<Customer> customers = new ArrayList<>();

    /**
     * Skapar en ny kund och lagrar den.
     *
     * @param name Kundens namn.
     * @param phone Kundens telefonnummer.
     * @param email Kundens e-post.
     * @param bikeModel Cykelmodell.
     * @param bikeBrand Cykelmärke.
     * @param bikeSerialNumber Serienummer.
     * @return Den skapade kunden.
     */
    public CustomerDTO createCustomer(String name, String phone, String email,
                                      String bikeModel, String bikeBrand, String bikeSerialNumber) {

        Customer customer = new Customer(name, phone, email,
                bikeModel, bikeBrand, bikeSerialNumber);

        customers.add(customer);

        return new CustomerDTO(customer);
    }

    /**
     * Hittar en kund via telefonnummer.
     *
     * @param phone Kundens telefonnummer.
     * @return Den hittade kunden, eller null om den inte finns.
     */
    public CustomerDTO findCustomer(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return new CustomerDTO(customer);
            }
        }
        return null;
    }
}