package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Simulerar användargränssnittet med hårdkodade anrop.
 */
public class View {
    private Controller controller;

    /**
     * Skapar en View med en controller.
     *
     * @param controller används för att anropa systemet
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Kör programmets flöde.
     */
    public void run() {
        // Hämta kund (eller skapa om den inte finns)
        CustomerDTO customer = controller.findCustomer("0701234567");

        if (customer == null) {
            customer = controller.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
            );
        }
        System.out.println(customer);

        // Skapa reparationsorder
        RepairOrderDTO order = controller.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );
        System.out.println(order);

        // Lägg till diagnos
        order = controller.addDiagnosticResult(
                "Battery must be replaced",
                "Replace battery",
                2500
        );
        System.out.println(order);

        // Acceptera ordern
        boolean customerAccepts = true;

        if (customerAccepts) {
            controller.acceptRequest();
        }
    }
}