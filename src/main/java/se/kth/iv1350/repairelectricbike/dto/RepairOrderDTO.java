package se.kth.iv1350.repairelectricbike.dto;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;

/**
 * Bär data för en reparationsorder.
 */
public class RepairOrderDTO {
    private String date;
    private String phone;
    private String problem;
    private String diagnostic;
    private String task;
    private double price;
    private String status;

    public RepairOrderDTO(RepairOrder order) {
        this.date = order.getDate();
        this.phone = order.getPhone();
        this.problem = order.getProblem();
        this.diagnostic = order.getDiagnostic();
        this.task = order.getTask();
        this.price = order.getPrice();
        this.status = order.getStatus().toString();
    }

    public String toString() {
        return "Repair order - Date: " + date +
                ", Customer phone: " + phone +
                ", Problem: " + problem +
                ", Diagnostic result: " + diagnostic +
                ", Repair task: " + task +
                ", Price: " + price +
                ", Status: " + status;
    }

    public String getPhone() {
    return phone;
    }

    public String getProblem() {
        return problem;
    }

    public String getStatus() {
        return status;
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
}