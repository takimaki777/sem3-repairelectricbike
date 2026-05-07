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

    /**
     * Creates a new repair order.
     *
     * @param date The date when the repair order was created.
     * @param phone The customer's phone number.
     * @param problem The problem with the bike.
     */
    public RepairOrder(String date, String phone, String problem) {
        this.date = date;
        this.phone = phone;
        this.problem = problem;
        this.status = RepairOrderStatus.CREATED;
    }

    /**
     * Adds diagnostic result and repair task to the repair order.
     *
     * @param diagnostic The diagnostic result.
     * @param task The repair task.
     * @param price The repair price.
     */
    public void addDiagnosticResult(String diagnostic, String task, double price) {
        this.diagnostic = diagnostic;
        this.task = task;
        this.price = price;
        this.status = RepairOrderStatus.DIAGNOSED;
    }

    /**
     * Accepts the repair order.
     */
    public void accept() {
        this.status = RepairOrderStatus.ACCEPTED;
    }

    /**
     * Completes the repair order.
     */
    public void complete() {
        this.status = RepairOrderStatus.COMPLETED;
    }

    /**
     * Gets the order date.
     *
     * @return The order date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the customer's phone number.
     *
     * @return The customer's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the bike problem.
     *
     * @return The bike problem.
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Gets the diagnostic result.
     *
     * @return The diagnostic result.
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * Gets the repair task.
     *
     * @return The repair task.
     */
    public String getTask() {
        return task;
    }

    /**
     * Gets the repair price.
     *
     * @return The repair price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the repair order status.
     *
     * @return The repair order status.
     */
    public RepairOrderStatus getStatus() {
        return status;
    }
}