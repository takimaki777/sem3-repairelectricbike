package se.kth.iv1350.repairelectricbike.controller;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerTest {

    private CustomerDTO createTestCustomer(Controller controller) {
        return controller.createCustomer(
                "Sven Svensson",
                "0701234567",
                "sven@gmail.com",
                "City E-Bike 500",
                "Monark",
                "SN12345"
        );
    }

    @Test
    public void createCustomerShouldReturnCustomerDTO() {
        Controller controller = new Controller();

        CustomerDTO customer = createTestCustomer(controller);

        assertNotNull(customer);
        assertEquals("Sven Svensson", customer.getName());
        assertEquals("0701234567", customer.getPhone());
    }

    @Test
    public void createRepairOrderShouldReturnCreatedOrder() {
        Controller controller = new Controller();
        CustomerDTO customer = createTestCustomer(controller);

        RepairOrderDTO order = controller.createRepairOrder(
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
    public void addDiagnosticResultShouldReturnDiagnosedOrder() {
        Controller controller = new Controller();
        CustomerDTO customer = createTestCustomer(controller);

        controller.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO order = controller.addDiagnosticResult(
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
    public void acceptRequestShouldReturnAcceptedOrder() {
        Controller controller = new Controller();
        CustomerDTO customer = createTestCustomer(controller);

        controller.createRepairOrder(
                customer,
                "Battery does not charge",
                "2026-04-23"
        );

        RepairOrderDTO acceptedOrder = controller.acceptRequest();

        assertNotNull(acceptedOrder);
        assertEquals("ACCEPTED", acceptedOrder.getStatus());
    }
}