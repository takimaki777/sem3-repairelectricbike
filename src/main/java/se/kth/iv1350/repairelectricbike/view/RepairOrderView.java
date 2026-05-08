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
        System.out.println(repairOrder);
    }
}