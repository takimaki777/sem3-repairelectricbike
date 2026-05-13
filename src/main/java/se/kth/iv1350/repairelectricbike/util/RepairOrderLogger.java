package se.kth.iv1350.repairelectricbike.util;

import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Logs updated repair orders to a file.
 */
public class RepairOrderLogger implements RepairOrderObserver {
    private FileLogger logger = new FileLogger();

    /**
     * Writes updated repair orders to a file.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void newRepairOrderUpdate(RepairOrderDTO repairOrder) {
        logger.log("Repair order update:");
        logger.log("Repair order - Date: " + repairOrder.getDate()
                + ", Customer phone: " + repairOrder.getPhone()
                + ", Problem: " + repairOrder.getProblem()
                + ", Diagnostic result: " + repairOrder.getDiagnostic()
                + ", Repair task: " + repairOrder.getTask()
                + ", Price: " + repairOrder.getPrice()
                + ", Status: " + repairOrder.getStatus());
    }
}