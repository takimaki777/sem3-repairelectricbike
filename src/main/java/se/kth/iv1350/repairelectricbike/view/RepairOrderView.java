package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Displays updated repair orders to the user.
 */
public class RepairOrderView implements RepairOrderObserver {

    /**
     * Prints updated repair orders.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void newRepairOrderUpdate(RepairOrderDTO repairOrder) {
        System.out.println("Repair order update:");

        System.out.println("Repair order - Date: " + repairOrder.getDate()
                + ", Customer phone: " + repairOrder.getPhone()
                + ", Problem: " + repairOrder.getProblem()
                + ", Diagnostic result: " + repairOrder.getDiagnostic()
                + ", Repair task: " + repairOrder.getTask()
                + ", Price: " + repairOrder.getPrice()
                + ", Status: " + repairOrder.getStatus());
    }
}