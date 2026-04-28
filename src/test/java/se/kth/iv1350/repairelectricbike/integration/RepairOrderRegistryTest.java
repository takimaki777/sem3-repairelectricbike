package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Tests the RepairOrderRegistry class.
 */
public class RepairOrderRegistryTest {
    /**
     * Tests that a repair order can be created.
     */
    @Test
    public void testCreateRepairOrder() {
        RepairOrderRegistry registry = new RepairOrderRegistry();

        CustomerDTO customer = new CustomerDTO(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        RepairOrderDTO repairOrder = registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        assertNotNull(repairOrder,
                "The created repair order should not be null.");
    }

    /**
     * Tests that diagnostic result and repair task can be added.
     */
    @Test
    public void testAddDiagnosticResult() {
        RepairOrderRegistry registry = new RepairOrderRegistry();

        CustomerDTO customer = new CustomerDTO(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );

        registry.createRepairOrder(customer,
                "Battery does not charge",
                "2026-04-23");

        RepairOrderDTO repairOrder = registry.addDiagnosticResult(
                "Battery must be replaced",
                "Replace battery",
                2500
        );

        assertNotNull(repairOrder,
                "Repair order should still exist after diagnostic result is added.");
    }
}