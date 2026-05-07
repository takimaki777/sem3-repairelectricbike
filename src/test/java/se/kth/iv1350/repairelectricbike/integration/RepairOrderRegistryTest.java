package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepairOrderRegistryTest {

    private CustomerDTO createTestCustomer() {
        return new CustomerDTO(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );
    }

    @Test
    public void createRepairOrderShouldReturnCreatedOrder() {
        RepairOrderRegistry registry = new RepairOrderRegistry();
        CustomerDTO customer = createTestCustomer();

        RepairOrderDTO order = registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        assertNotNull(order);
        assertEquals("0701234567", order.getPhone());
        assertEquals("Battery does not charge", order.getProblem());
        assertEquals("CREATED", order.getStatus());
    }

    @Test
    public void getRepairOrderShouldReturnCreatedOrder() {
        RepairOrderRegistry registry = new RepairOrderRegistry();
        CustomerDTO customer = createTestCustomer();

        registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO foundOrder = registry.getRepairOrder("0701234567");

        assertNotNull(foundOrder);
        assertEquals("0701234567", foundOrder.getPhone());
        assertEquals("Battery does not charge", foundOrder.getProblem());
        assertEquals("CREATED", foundOrder.getStatus());
    }

    @Test
    public void getRepairOrderWhenNoneExistsShouldReturnNull() {
        RepairOrderRegistry registry = new RepairOrderRegistry();

        RepairOrderDTO foundOrder = registry.getRepairOrder("0701234567");

        assertNull(foundOrder);
    }

    @Test
    public void addDiagnosticResultShouldUpdateCurrentOrder() {
        RepairOrderRegistry registry = new RepairOrderRegistry();
        CustomerDTO customer = createTestCustomer();

        registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO order = registry.addDiagnosticResult(
                "Battery must be replaced",
                "Replace battery",
                2500
        );

        assertNotNull(order);
        assertEquals("DIAGNOSED", order.getStatus());
        assertEquals("Battery must be replaced", order.getDiagnostic());
        assertEquals("Replace battery", order.getTask());
        assertEquals(2500, order.getPrice());
    }

    @Test
    public void acceptCurrentRepairOrderShouldUpdateStatusToAccepted() {
        RepairOrderRegistry registry = new RepairOrderRegistry();
        CustomerDTO customer = createTestCustomer();

        registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO order = registry.acceptCurrentRepairOrder();

        assertNotNull(order);
        assertEquals("ACCEPTED", order.getStatus());
    }

    @Test
    public void getRepairOrderWithWrongPhoneShouldReturnNull() {
        RepairOrderRegistry registry = new RepairOrderRegistry();
        CustomerDTO customer = createTestCustomer();

        registry.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO foundOrder = registry.getRepairOrder("0000000000");

        assertNull(foundOrder);
        }
}