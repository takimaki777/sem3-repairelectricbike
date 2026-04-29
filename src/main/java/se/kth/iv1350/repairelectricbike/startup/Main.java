package se.kth.iv1350.repairelectricbike.startup;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.view.View;

/**
 * Startar applikationen.
 */
public class Main {
    /**
     * Startar programmet.
     *
     * @param args Argument som kan 
     * skickas in vid start av programmet. 
     * Används inte i detta program.
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);

        view.run();
    }
}