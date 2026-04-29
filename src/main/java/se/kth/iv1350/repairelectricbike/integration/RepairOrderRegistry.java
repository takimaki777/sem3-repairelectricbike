package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Lagrar reparationsorder.
 */
public class RepairOrderRegistry {
    private RepairOrderDTO currentRepairOrder;

    /**
     * Skapar en ny reparationsorder.
     *
     * @param customer Kunden.
     * @param problem Problembeskrivning.
     * @param date Datum för reparationsordern.
     * @return Den skapade reparationsordern.
     */
    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        currentRepairOrder = new RepairOrderDTO(date, customer.getPhone(), problem);
        return currentRepairOrder;
    }

    /**
     * Hämtar den aktuella reparationsordern.
     *
     * @param phone Kundens telefonnummer.
     * @return Reparationsordern, eller null om den inte finns.
     */
    public RepairOrderDTO getRepairOrder(String phone) {
        if (currentRepairOrder != null) {
            return currentRepairOrder;
        }
        return null;
    }

    /**
     * Lägger till diagnos och åtgärd.
     *
     * @param diagnostic Diagnosresultat.
     * @param task Åtgärd.
     * @param price Pris för reparationen.
     * @return Den uppdaterade reparationsordern.
     */
    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        currentRepairOrder.addDiagnosticResult(diagnostic, task, price);
        return currentRepairOrder;
    }
   /**
     * Skriver ut reparationsordern.
     */
    public void printRepairOrder() {
        System.out.println("Accepted request:");
        System.out.println(currentRepairOrder);
    }
}