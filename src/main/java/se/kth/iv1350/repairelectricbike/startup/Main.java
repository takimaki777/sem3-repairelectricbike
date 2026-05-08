package se.kth.iv1350.repairelectricbike.startup;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.view.View;

/**
 * Starts the application.
 */
public class Main {

    /**
     * Starts the program.
     *
     * @param args Arguments that can be passed when starting the program.
     *             Not used in this program.
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);

        view.run();
    }
}