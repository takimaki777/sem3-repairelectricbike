package se.kth.iv1350.repairelectricbike.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepairOrderTest {

    @Test
    public void newRepairOrderShouldHaveCreatedStatus() {
        RepairOrder order = new RepairOrder(
                "2026-04-23",
                "0701234567",
                "Battery does not charge"
        );

        assertEquals(RepairOrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void addDiagnosticResultShouldChangeStatusToDiagnosed() {
        RepairOrder order = new RepairOrder(
                "2026-04-23",
                "0701234567",
                "Battery does not charge"
        );

        order.addDiagnosticResult(
                "Battery must be replaced",
                "Replace battery",
                2500
        );

        assertEquals(RepairOrderStatus.DIAGNOSED, order.getStatus());
        assertEquals("Battery must be replaced", order.getDiagnostic());
        assertEquals("Replace battery", order.getTask());
        assertEquals(2500, order.getPrice());
    }

    @Test
    public void acceptShouldChangeStatusToAccepted() {
        RepairOrder order = new RepairOrder(
                "2026-04-23",
                "0701234567",
                "Battery does not charge"
        );

        order.accept();

        assertEquals(RepairOrderStatus.ACCEPTED, order.getStatus());
    }
}