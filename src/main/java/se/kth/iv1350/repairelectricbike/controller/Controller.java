package se.kth.iv1350.repairelectricbike.controller;

import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Coordinates calls between view and the rest of the system.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;

    /**
     * Creates a new Controller.
     *
     * @param customerRegistry The customer registry.
     * @param repairOrderRegistry The repair order registry.
     */
    public Controller(CustomerRegistry customerRegistry,
                      RepairOrderRegistry repairOrderRegistry) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
    }

    /**
     * Creates a new customer.
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
        return customerRegistry.createCustomer(name, phone, email,
                bikeModel, bikeBrand, bikeSerialNumber);
    }

    /**
     * Finds a customer by phone number.
     *
     * @param phone The customer's phone number.
     * @return The found customer, or null if not found.
     */
    public CustomerDTO findCustomer(String phone) {
        return customerRegistry.findCustomer(phone);
    }

    /**
     * Creates a repair order.
     *
     * @param customer The customer.
     * @param problem The problem description.
     * @param date The date of the repair order.
     * @return The created repair order.
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        return repairOrderRegistry.createRepairOrder(customer, problem, date);
    }

    /**
     * Gets a repair order.
     *
     * @param phone The customer's phone number.
     * @return The repair order, or null if not found.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        return repairOrderRegistry.getRepairOrder(phone);
    }

    /**
     * Adds diagnostic result and repair task.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The price of the repair.
     * @return The updated repair order.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        return repairOrderRegistry.addDiagnosticResult(diagnostic, task, price);
    }

    /**
     * Accepts the request and prints the repair order.
     */
    public void acceptRequest() {
        repairOrderRegistry.printRepairOrder();
    }
}