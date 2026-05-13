package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * Stores repair orders.
 */
public class RepairOrderRegistry {
    private RepairOrder currentRepairOrder;
    private List<RepairOrderObserver> repairOrderObservers = new ArrayList<>();

    /**
     * Adds an observer that will be notified when a repair order is updated.
     *
     * @param observer The observer to add.
     */
    public void addRepairOrderObserver(RepairOrderObserver observer) {
        repairOrderObservers.add(observer);
    }

    /**
     * Creates a new repair order.
     *
     * @param customer The customer who owns the bike.
     * @param problem The problem description.
     * @param date The date of the repair order.
     * @return The created repair order.
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        currentRepairOrder = new RepairOrder(date, customer.getPhone(), problem);
        RepairOrderDTO orderDTO = new RepairOrderDTO(currentRepairOrder);
        notifyObservers(orderDTO);
        return orderDTO;
    }

    /**
     * Retrieves the current repair order.
     *
     * @param phone The customer's phone number.
     * @return The current repair order, or null if no matching repair order exists.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        if (currentRepairOrder != null && currentRepairOrder.getPhone().equals(phone)) {
            return new RepairOrderDTO(currentRepairOrder);
        }
        return null;
    }

    /**
     * Adds a diagnostic result and repair task.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The repair price.
     * @return The updated repair order.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        currentRepairOrder.addDiagnosticResult(diagnostic, task, price);
        RepairOrderDTO orderDTO = new RepairOrderDTO(currentRepairOrder);
        notifyObservers(orderDTO);
        return orderDTO;
    }

    /**
     * Accepts the current repair order.
     *
     * @return The accepted repair order.
     */
    public RepairOrderDTO acceptCurrentRepairOrder() {
        currentRepairOrder.accept();
        RepairOrderDTO orderDTO = new RepairOrderDTO(currentRepairOrder);
        notifyObservers(orderDTO);
        return orderDTO;
    }

    /**
     * Completes the current repair order.
     *
     * @return the completed repair order.
     */
    public RepairOrderDTO completeCurrentRepairOrder() {
        currentRepairOrder.complete();

        RepairOrderDTO completedOrder =
                new RepairOrderDTO(currentRepairOrder);

        notifyObservers(completedOrder);

        return completedOrder;
    }

    /**
     * Notifies all observers about an updated repair order.
     *
     * @param orderDTO The updated repair order.
     */
    private void notifyObservers(RepairOrderDTO orderDTO) {
        for (RepairOrderObserver observer : repairOrderObservers) {
            observer.newRepairOrderUpdate(orderDTO);
        }
    }
}