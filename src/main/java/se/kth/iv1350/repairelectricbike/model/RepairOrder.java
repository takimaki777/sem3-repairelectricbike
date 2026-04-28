package se.kth.iv1350.repairelectricbike.model;

/**
 * Represents a repair order.
 */
public class RepairOrder {
    private String problem;
    private String date;

    public RepairOrder(String problem, String date) {
        this.problem = problem;
        this.date = date;
    }
}