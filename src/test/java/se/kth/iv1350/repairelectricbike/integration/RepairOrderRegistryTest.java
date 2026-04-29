package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

/**
 * Testar klassen RepairOrderRegistry.
 */
public class RepairOrderRegistryTest {
    /**
     * Testar att en reparationsorder kan skapas.
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
                "Den skapade reparationsordern ska inte vara null.");
    }

    /**
     * Testar att diagnos och åtgärd kan läggas till.
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
                "Reparationsordern ska fortfarande finnas efter att diagnos lagts till.");
   
        }
        /**
         * Testar att null returneras när ingen reparationsorder finns.
         */
        @Test
               public void testGetRepairOrderWhenNoneExists() {
               RepairOrderRegistry registry = new RepairOrderRegistry();

               RepairOrderDTO repairOrder = registry.getRepairOrder("0701234567");

                assertNull(repairOrder,
                "Ingen reparationsorder ska hittas när ingen order har skapats.");
        }


        /**
 * Testar att en skapad reparationsorder kan hämtas.
 */
@Test
public void testGetCreatedRepairOrder() {
    RepairOrderRegistry registry = new RepairOrderRegistry();

    CustomerDTO customer = new CustomerDTO(
            "Sven Svensson",
            "0701234567",
            "sven@gmail.com",
            "City E-Bike 500",
            "Monark",
            "SN12345"
    );

    RepairOrderDTO createdOrder = registry.createRepairOrder(
            customer,
            "Battery does not charge",
            "2026-04-23"
    );

    RepairOrderDTO foundOrder = registry.getRepairOrder("0701234567");

    assertEquals(createdOrder, foundOrder,
            "Den hittade reparationsordern ska vara samma som den skapade.");
}
}