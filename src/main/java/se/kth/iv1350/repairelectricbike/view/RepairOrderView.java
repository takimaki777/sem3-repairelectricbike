package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Shows updates about repair orders in the user interface.
 */
public class RepairOrderView implements RepairOrderObserver {

    /**
     * Prints information about an updated repair order.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void newRepairOrderUpdate(RepairOrderDTO repairOrder) {
        System.out.println("Repair order update:");
        System.out.println("Date: " + repairOrder.getDate());
        System.out.println("Customer phone: " + repairOrder.getPhone());
        System.out.println("Problem: " + repairOrder.getProblem());

        if (repairOrder.getDiagnostic() != null) {
            System.out.println("Diagnostic result: " + repairOrder.getDiagnostic());
        }

        if (repairOrder.getTask() != null) {
            System.out.println("Repair task: " + repairOrder.getTask());
        }

        if (repairOrder.getPrice() != 0.0) {
            System.out.println("Price: " + repairOrder.getPrice());
        }

        System.out.println("Status: " + repairOrder.getStatus());
        System.out.println();
    }
}