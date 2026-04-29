package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;

/**
 * Lagrar kunder (simulerar en databas).
 */
public class CustomerRegistry {
    private List<CustomerDTO> customers = new ArrayList<>();

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

        CustomerDTO customer = new CustomerDTO(name, phone, email,
                bikeModel, bikeBrand, bikeSerialNumber);

        customers.add(customer);

        return customer;
    }

    /**
     * Hittar en kund via telefonnummer.
     *
     * @param phone Kundens telefonnummer.
     * @return Den hittade kunden, eller null om den inte finns.
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