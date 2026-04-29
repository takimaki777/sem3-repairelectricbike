package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Skriver ut reparationsorder.
 */
public class Printer {
    /**
     * Skriver ut den angivna reparationsordern.
     *
     * @param repairOrder Den reparationsorder som ska skrivas ut.
     */
    public void printRepairOrder(RepairOrderDTO repairOrder) {
        System.out.println("Accepted request:");
        System.out.println(repairOrder);
    }
}