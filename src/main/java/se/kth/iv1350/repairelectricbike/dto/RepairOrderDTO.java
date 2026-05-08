package se.kth.iv1350.repairelectricbike.dto;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;

/**
 * Carries data for a repair order.
 */
public class RepairOrderDTO {
    private String date;
    private String phone;
    private String problem;
    private String diagnostic;
    private String task;
    private double price;
    private String status;

    /**
     * Creates a new RepairOrderDTO from a RepairOrder object.
     *
     * @param order The repair order whose data will be copied.
     */
    public RepairOrderDTO(RepairOrder order) {
        this.date = order.getDate();
        this.phone = order.getPhone();
        this.problem = order.getProblem();
        this.diagnostic = order.getDiagnostic();
        this.task = order.getTask();
        this.price = order.getPrice();
        this.status = order.getStatus().toString();
    }

    /**
     * Returns a string representation of the repair order.
     *
     * @return A string containing repair order information.
     */
    @Override
    public String toString() {
        return "Repair order - Date: " + date +
                ", Customer phone: " + phone +
                ", Problem: " + problem +
                ", Diagnostic result: " + diagnostic +
                ", Repair task: " + task +
                ", Price: " + price +
                ", Status: " + status;
    }

    /**
     * Returns the customer's phone number.
     *
     * @return The customer's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the problem description.
     *
     * @return The problem description.
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Returns the repair order status.
     *
     * @return The repair order status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the diagnostic result.
     *
     * @return The diagnostic result.
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * Returns the repair task.
     *
     * @return The repair task.
     */
    public String getTask() {
        return task;
    }

    /**
     * Returns the repair price.
     *
     * @return The repair price.
     */
    public double getPrice() {
        return price;
    }
}