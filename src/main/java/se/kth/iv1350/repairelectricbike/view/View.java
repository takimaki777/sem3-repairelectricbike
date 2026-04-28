package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Simulates the user interface with hard-coded calls.
 */
public class View {
    private Controller controller;

    /**
     * Creates a new View.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs the program flow.
     */
    public void run() {
        // Create customer
        CustomerDTO customer = controller.createCustomer(
        "Sven Svensson",
        "0701234567",
        "sven@gmail.com",
        "City E-Bike 500",
        "Monark",
        "SN12345"
        );
        System.out.println(customer);

        // Create repair order
        RepairOrderDTO order = controller.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );
        System.out.println(order);

        // Add diagnostic result
        order = controller.addDiagnosticResult(
                "Battery must be replaced",
                "Replace battery",
                2500
        );
        System.out.println(order);

        // Accept and print
        controller.acceptRequest();
    }
}