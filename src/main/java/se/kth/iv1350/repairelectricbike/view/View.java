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

        System.out.println("Customer: " + customer.getName()
                + ", Email: " + customer.getEmail()
                + ", Phone: " + customer.getPhone()
                + ", Bike brand: " + customer.getBikeBrand()
                + ", Bike model: " + customer.getBikeModel()
                + ", Bike serial number: " + customer.getBikeSerialNumber());

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
                RepairOrderDTO acceptedOrder = controller.acceptRequest();

                System.out.println("Accepted request:");

                System.out.println("Repair order - Date: " + acceptedOrder.getDate()
                        + ", Customer phone: " + acceptedOrder.getPhone()
                        + ", Problem: " + acceptedOrder.getProblem()
                        + ", Diagnostic result: " + acceptedOrder.getDiagnostic()
                        + ", Repair task: " + acceptedOrder.getTask()
                        + ", Price: " + acceptedOrder.getPrice()
                        + ", Status: " + acceptedOrder.getStatus());

                RepairOrderDTO completedOrder = controller.completeRepairOrder();

                System.out.println("Completed repair order:");

                System.out.println("Repair order - Date: " + completedOrder.getDate()
                        + ", Customer phone: " + completedOrder.getPhone()
                        + ", Problem: " + completedOrder.getProblem()
                        + ", Diagnostic result: " + completedOrder.getDiagnostic()
                        + ", Repair task: " + completedOrder.getTask()
                        + ", Price: " + completedOrder.getPrice()
                        + ", Status: " + completedOrder.getStatus());
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