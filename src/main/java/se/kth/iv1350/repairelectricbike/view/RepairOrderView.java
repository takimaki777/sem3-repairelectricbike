package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Displays updated repair orders to the user.
 */
public class RepairOrderView implements RepairOrderObserver {

    /**
     * Prints the updated repair order.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void newRepairOrderUpdate(RepairOrderDTO repairOrder) {
        System.out.println("Repair order update:");
        printRepairOrder(repairOrder);
    }

    private void printRepairOrder(RepairOrderDTO repairOrder) {
        System.out.println("Date: " + repairOrder.getDate());
        System.out.println("Customer phone: " + repairOrder.getPhone());
        System.out.println("Problem: " + repairOrder.getProblem());
        System.out.println("Diagnostic result: " + repairOrder.getDiagnostic());
        System.out.println("Repair task: " + repairOrder.getTask());
        System.out.println("Price: " + repairOrder.getPrice());
        System.out.println("Status: " + repairOrder.getStatus());
    }
}