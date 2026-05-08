package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerNotFoundException;
import se.kth.iv1350.repairelectricbike.integration.DatabaseFailureException;
import se.kth.iv1350.repairelectricbike.util.FileLogger;
import se.kth.iv1350.repairelectricbike.util.RepairOrderLogger;

/**
 * Simulates the user interface with hard-coded calls.
 */
public class View {
    private Controller controller;
    private FileLogger errorLogger = new FileLogger();

    /**
     * Creates a View with a controller.
     *
     * @param controller Used to call the system.
     */
    public View(Controller controller) {
        this.controller = controller;
        this.controller.addRepairOrderObserver(new RepairOrderView());
        this.controller.addRepairOrderObserver(new RepairOrderLogger());
    }

    /**
     * Runs the program flow.
     */
    public void run() {
        System.out.println("\n--- Successful repair order flow ---");

        CustomerDTO customer = controller.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        System.out.println(customer);

        try {
            customer = controller.findCustomer("0701234567");

            RepairOrderDTO order = controller.createRepairOrder(
                    customer,
                    "Battery does not charge",
                    "2026-04-23"
            );

            order = controller.addDiagnosticResult(
                    "Battery must be replaced",
                    "Replace battery",
                    2500
            );

            boolean customerAccepts = true;
            if (customerAccepts) {
                controller.acceptRequest();
            }
        } catch (CustomerNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (DatabaseFailureException exception) {
            System.out.println(exception.getMessage());
            errorLogger.log("Database failure: " + exception.getMessage());
        }

        System.out.println("\n--- Search for non-existing customer ---");

        try {
            controller.findCustomer("0000000000");
        } catch (CustomerNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (DatabaseFailureException exception) {
            System.out.println(exception.getMessage());
            errorLogger.log("Database failure: " + exception.getMessage());
        }

        System.out.println("\n--- Simulated database failure ---");

        try {
            controller.findCustomer("9999999999");
        } catch (CustomerNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (DatabaseFailureException exception) {
            System.out.println(exception.getMessage());
            errorLogger.log("Database failure: " + exception.getMessage());
        }
    }
}