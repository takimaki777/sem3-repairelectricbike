package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a repair order.
 */
public class RepairOrder {
    private String date;
    private String phone;
    private String problem;
    private String diagnostic;
    private String task;
    private double price;
    private RepairOrderStatus status;

    public RepairOrder(String date, String phone, String problem) {
        this.date = date;
        this.phone = phone;
        this.problem = problem;
        this.status = RepairOrderStatus.CREATED;
    }

    public void addDiagnosticResult(String diagnostic, String task, double price) {
        this.diagnostic = diagnostic;
        this.task = task;
        this.price = price;
        this.status = RepairOrderStatus.DIAGNOSED;
    }

    public void accept() {
        this.status = RepairOrderStatus.ACCEPTED;
    }

    public void complete() {
        this.status = RepairOrderStatus.COMPLETED;
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

    public RepairOrderStatus getStatus() {
        return status;
    }
}