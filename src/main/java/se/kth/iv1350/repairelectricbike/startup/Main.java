package se.kth.iv1350.repairelectricbike.startup;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.view.View;

/**
 * Starts the application.
 */
public class Main {
    /**
     * Starts the Repair Electric Bike program.
     *
     * @param args The program does not use command line parameters.
     */
    public static void main(String[] args) {
        CustomerRegistry customerRegistry = new CustomerRegistry();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();

        Controller controller = new Controller(customerRegistry, repairOrderRegistry);
        View view = new View(controller);

        view.run();
    }
}