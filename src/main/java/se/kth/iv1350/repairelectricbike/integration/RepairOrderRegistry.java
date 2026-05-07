package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;

/**
 * Stores repair orders.
 */
public class RepairOrderRegistry {
    private RepairOrder currentRepairOrder;

    /**
     * Creates and stores a new repair order.
     *
     * @param customer The customer who owns the bike.
     * @param problem The problem with the bike.
     * @param date The date when the order was created.
     * @return The created repair order.
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        currentRepairOrder = new RepairOrder(date, customer.getPhone(), problem);
        return new RepairOrderDTO(currentRepairOrder);
    }

    /**
     * Finds the current repair order by customer phone number.
     *
     * @param phone The customer's phone number.
     * @return The repair order, or null if no matching order exists.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        if (currentRepairOrder != null && currentRepairOrder.getPhone().equals(phone)) {
            return new RepairOrderDTO(currentRepairOrder);
        }

        return null;
    }

    /**
     * Adds diagnostic result and repair task to the current repair order.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The repair price.
     * @return The updated repair order.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        currentRepairOrder.addDiagnosticResult(diagnostic, task, price);
        return new RepairOrderDTO(currentRepairOrder);
    }

    /**
     * Accepts the current repair order.
     *
     * @return The accepted repair order.
     */
    public RepairOrderDTO acceptCurrentRepairOrder() {
        currentRepairOrder.accept();
        return new RepairOrderDTO(currentRepairOrder);
    }
}