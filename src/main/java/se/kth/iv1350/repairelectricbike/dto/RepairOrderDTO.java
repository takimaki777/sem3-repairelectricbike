package se.kth.iv1350.repairelectricbike.dto;

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

    /**
     * Skapar en ny RepairOrderDTO.
     */
    public RepairOrderDTO(String date, String phone, String problem) {
        this.date = date;
        this.phone = phone;
        this.problem = problem;
    }
    
    /**
     * Lägger till diagnos, åtgärd och pris.
     *
     * @param diagnostic diagnos
     * @param task åtgärd
     * @param price pris
     */
    public void addDiagnosticResult(String diagnostic, String task, double price) {
        this.diagnostic = diagnostic;
        this.task = task;
        this.price = price;
    }


    /**
     * Returnerar en strängrepresentation av reparationsordern.
     */
    public String toString() {
        return "Repair order - Date: " + date +
                ", Customer phone: " + phone +
                ", Problem: " + problem +
                ", Diagnostic result: " + diagnostic +
                ", Repair task: " + task +
                ", Price: " + price;
    }
}