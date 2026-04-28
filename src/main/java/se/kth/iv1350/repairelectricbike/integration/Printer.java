package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Prints repair orders.
 */
public class Printer {
    /**
     * Prints the specified repair order.
     *
     * @param repairOrder The repair order to print.
     */
    public void printRepairOrder(RepairOrderDTO repairOrder) {
        System.out.println("Accepted request:");
        System.out.println(repairOrder);
    }
}