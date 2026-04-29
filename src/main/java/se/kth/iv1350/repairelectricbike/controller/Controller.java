package se.kth.iv1350.repairelectricbike.controller;

import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Kopplar ihop View med resten av systemet.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;

    /**
     * Skapar en controller och initierar registren.
     */
    public Controller() {
        this.customerRegistry = new CustomerRegistry();
        this.repairOrderRegistry = new RepairOrderRegistry();
        this.printer = new Printer();
    }

    /**
     * Skapar en ny kund.
     *
     * @param name kundens namn
     * @param phone kundens telefonnummer
     * @param email kundens e-post
     * @param bikeModel cykelmodell
     * @param bikeBrand cykelmärke
     * @param bikeSerialNumber serienummer
     * @return den skapade kunden
     */
    public CustomerDTO createCustomer(String name, String phone, String email,
                                      String bikeModel, String bikeBrand, String bikeSerialNumber) {
        return customerRegistry.createCustomer(name, phone, email,
                bikeModel, bikeBrand, bikeSerialNumber);
    }

    /**
     * Letar upp en kund via telefonnummer.
     *
     * @param phone telefonnummer
     * @return kunden, eller null om den inte finns
     */
    public CustomerDTO findCustomer(String phone) {
        return customerRegistry.findCustomer(phone);
    }

    /**
     * Skapar en reparationsorder.
     *
     * @param customer kunden
     * @param problem beskrivning av problemet
     * @param date datum
     * @return den skapade ordern
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        return repairOrderRegistry.createRepairOrder(customer, problem, date);
    }

    /**
     * Hämtar en reparationsorder.
     *
     * @param phone telefonnummer
     * @return ordern, eller null om den inte finns
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        return repairOrderRegistry.getRepairOrder(phone);
    }

    /**
     * Lägger till diagnos och åtgärd.
     *
     * @param diagnostic diagnos
     * @param task åtgärd
     * @param price pris
     * @return uppdaterad order
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        return repairOrderRegistry.addDiagnosticResult(diagnostic, task, price);
    }

    /**
     * Accepterar ordern och skriver ut den.
     */
    public void acceptRequest() {
        RepairOrderDTO order = repairOrderRegistry.getRepairOrder(null);
        printer.printRepairOrder(order);
    }
}