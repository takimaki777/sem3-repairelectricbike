package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Stores repair orders.
 */
public class RepairOrderRegistry {
    private RepairOrderDTO currentRepairOrder;

    /**
     * Creates a new repair order.
     *
     * @param customer The customer.
     * @param problem The problem description.
     * @param date The date of the repair order.
     * @return The created repair order.
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        currentRepairOrder = new RepairOrderDTO(date, customer.getPhone(), problem);
        return currentRepairOrder;
    }

    /**
     * Gets the current repair order.
     *
     * @param phone The customer's phone number.
     * @return The repair order, or null if not found.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        if (currentRepairOrder != null) {
            return currentRepairOrder;
        }
        return null;
    }

    /**
     * Adds diagnostic result and repair task.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The price of the repair.
     * @return The updated repair order.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        currentRepairOrder.setDiagnostic(diagnostic, task, price);
        return currentRepairOrder;
    }

    /**
     * Prints the repair order.
     */
    public void printRepairOrder() {
        System.out.println("Accepted request:");
        System.out.println(currentRepairOrder);
    }
}