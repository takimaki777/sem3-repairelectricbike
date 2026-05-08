package se.kth.iv1350.repairelectricbike.controller;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerNotFoundException;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.DatabaseFailureException;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Connects the View with the rest of the system.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;

    /**
     * Creates a controller and initializes the registries.
     */
    public Controller() {
        this.customerRegistry = new CustomerRegistry();
        this.repairOrderRegistry = new RepairOrderRegistry();
        this.printer = new Printer();
    }

    /**
     * Adds an observer for repair orders.
     *
     * @param observer The observer that will receive updates.
     */
    public void addRepairOrderObserver(RepairOrderObserver observer) {
        repairOrderRegistry.addRepairOrderObserver(observer);
    }

    /**
     * Creates a new customer.
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
        return customerRegistry.createCustomer(name, phone, email, bikeModel,
                bikeBrand, bikeSerialNumber);
    }

    /**
     * Searches for a customer using a phone number.
     *
     * @param phone The customer's phone number.
     * @return The found customer.
     * @throws CustomerNotFoundException If the customer does not exist.
     * @throws DatabaseFailureException If the customer registry cannot be reached.
     */
    public CustomerDTO findCustomer(String phone)
            throws CustomerNotFoundException, DatabaseFailureException {
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
     * Retrieves a repair order.
     *
     * @param phone The customer's phone number.
     * @return The repair order, or null if no repair order exists.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        return repairOrderRegistry.getRepairOrder(phone);
    }

    /**
     * Adds a diagnostic result and repair task.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The repair price.
     * @return The updated repair order.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        return repairOrderRegistry.addDiagnosticResult(diagnostic, task, price);
    }

    /**
     * Accepts the repair order and prints it.
     *
     * @return The accepted repair order.
     */
    public RepairOrderDTO acceptRequest() {
        RepairOrderDTO order = repairOrderRegistry.acceptCurrentRepairOrder();
        printer.printRepairOrder(order);
        return order;
    }
}