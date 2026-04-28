package se.kth.iv1350.repairelectricbike.dto;

/**
 * Carries repair order data.
 */
public class RepairOrderDTO {
    private String date;
    private String phone;
    private String problem;
    private String diagnostic;
    private String task;
    private double price;

    /**
     * Creates a new RepairOrderDTO.
     */
    public RepairOrderDTO(String date, String phone, String problem) {
        this.date = date;
        this.phone = phone;
        this.problem = problem;
    }

    public void setDiagnostic(String diagnostic, String task, double price) {
        this.diagnostic = diagnostic;
        this.task = task;
        this.price = price;
    }

    public String toString() {
        return "Repair order - Date: " + date +
                ", Customer phone: " + phone +
                ", Problem: " + problem +
                ", Diagnostic result: " + diagnostic +
                ", Repair task: " + task +
                ", Price: " + price;
    }
}