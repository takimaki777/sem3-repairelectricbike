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
        System.out.println(formatRepairOrder(repairOrder));
    }

    private String formatRepairOrder(RepairOrderDTO repairOrder) {
        return "Repair order - Date: " + repairOrder.getDate()
                + ", Customer phone: " + repairOrder.getPhone()
                + ", Problem: " + repairOrder.getProblem()
                + ", Diagnostic result: " + repairOrder.getDiagnostic()
                + ", Repair task: " + repairOrder.getTask()
                + ", Price: " + repairOrder.getPrice()
                + ", Status: " + repairOrder.getStatus();
    }
}