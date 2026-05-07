package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;

/**
 * Lagrar reparationsorder.
 */
public class RepairOrderRegistry {
    private RepairOrder currentRepairOrder;

    public RepairOrderDTO createRepairOrder(CustomerDTO customer, String problem, String date) {
        currentRepairOrder = new RepairOrder(date, customer.getPhone(), problem);
        return new RepairOrderDTO(currentRepairOrder);
    }

    public RepairOrderDTO getRepairOrder(String phone) {
        if (currentRepairOrder != null) {
            return new RepairOrderDTO(currentRepairOrder);
        }
        return null;
    }

    public RepairOrderDTO addDiagnosticResult(String diagnostic, String task, double price) {
        currentRepairOrder.addDiagnosticResult(diagnostic, task, price);
        return new RepairOrderDTO(currentRepairOrder);
    }

    public RepairOrderDTO acceptCurrentRepairOrder() {
        currentRepairOrder.accept();
        return new RepairOrderDTO(currentRepairOrder);
    }
}