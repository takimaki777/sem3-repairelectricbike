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

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getProblem() {
        return problem;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getTask() {
        return task;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}