package se.kth.iv1350.repairelectricbike.model;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Observer that receives updates when a repair order is updated.
 */
public interface RepairOrderObserver {

    /**
     * Called when a repair order has been updated.
     *
     * @param repairOrder The updated repair order.
     */
    void newRepairOrderUpdate(RepairOrderDTO repairOrder);
}