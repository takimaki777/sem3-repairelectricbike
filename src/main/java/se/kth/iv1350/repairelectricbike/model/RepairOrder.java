package se.kth.iv1350.repairelectricbike.model;

/**
 * Representerar en repair order.
 */
public class RepairOrder {
    private String problem;
    private String date;

    public RepairOrder(String problem, String date) {
        this.problem = problem;
        this.date = date;
    }
}