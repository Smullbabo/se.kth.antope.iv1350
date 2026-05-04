package controller;

import dto.CustomerDTO;
import dto.DiagnosticReportDTO;
import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import integration.CustomerRegistryHandler;
import integration.PrinterHandler;
import integration.RepairOrderRegistryHandler;
import integration.RepairTaskRegistryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Controller class.
 */
public class ControllerTest {
    private Controller controller;

    /**
     * Creates a new controller with fresh registries before each test.
     */
    @BeforeEach
    public void setUp() {
        controller = new Controller(
                new CustomerRegistryHandler(),
                new RepairOrderRegistryHandler(),
                new RepairTaskRegistryHandler(),
                new PrinterHandler()
        );
    }

    /**
     * Tests that an existing customer can be found.
     */
    @Test
    public void testFindExistingCustomer() {
        CustomerDTO customer = controller.findCustomer("0701234567");

        assertNotNull(customer);
        assertEquals("0701234567", customer.getPhoneNumber(), "Phone number of the retrieved customer does not match!");
    }

    /**
     * Tests that a non-existing customer returns null.
     */
    @Test
    public void testFindNonExistingCustomerReturnsNull() {
        CustomerDTO customer = controller.findCustomer("0000000000");

        assertNull(customer,"Non existing customer returned something other than null: " + customer);
    }

    /**
     * Tests that a repair order can be created and then found by bike serial number.
     */
    @Test
    public void testCreateAndFindRepairOrder() {
        controller.createRepairOrder("Battery problem", "0701234567", 1001);

        RepairOrderDTO repairOrder = controller.findRepairOrder(1001);

        assertNotNull(repairOrder,"Repair Order is null!");
        assertEquals("Battery problem", repairOrder.getProblemDescription(),"Description does not match expected!");
        assertEquals("0701234567", repairOrder.getCustomerPhoneNumber(),"Phone number does not match expected!");
        assertEquals(1001, repairOrder.getBikeSerialNumber(),"Serial number does not match expected!");
    }

    /**
     * Tests that the repair order id can be retrieved from a customer phone number.
     */
    @Test
    public void testGetRepairOrderIdFromPhone() {
        controller.createRepairOrder("test problem", "0701234567", 2002);

        int repairOrderId = controller.getRepairOrderIdFromPhone("0701234567");

        assertTrue(repairOrderId > 0,"RepairOrder has id lower than 1 therefore something has gone wrong!");
    }

    /**
     * Tests that all repair tasks can be retrieved.
     */
    @Test
    public void testGetAllRepairTasks() {
        List<RepairTaskDTO> tasks = controller.getAllRepairTasks();

        assertNotNull(tasks,"Task should not return null!");
    }

    /**
     * Tests that a diagnostic report can be added to an existing repair order.
     */
    @Test
    public void testAddDiagnosticReport() {
        controller.createRepairOrder("test problem", "0701234567", 3003);
        int repairOrderId = controller.getRepairOrderIdFromPhone("0701234567");


        List<RepairTaskDTO> selectedTasks = new ArrayList<>();
        selectedTasks.add(new RepairTaskDTO(1, "test task", "test task", 299));

        controller.addDiagnosticReport(repairOrderId, "test case need adjustment", selectedTasks);

        DiagnosticReportDTO report = controller.getDiagnosticReport("0701234567");

        assertNotNull(report, "Report missing! Should not be null");
        assertEquals("test case need adjustment", report.getDescription(),"Description does not match expected value!");
        assertEquals(299, report.getTotalCost(),"Total cost does not equal expected value!");
    }


    /**
     * Tests that a repair order can be accepted.
     */
    @Test
    public void testAcceptRepairOrder() {
        controller.createRepairOrder("Wheel problem", "0701234567", 4004);
        int repairOrderId = controller.getRepairOrderIdFromPhone("0701234567");

        controller.acceptRepairOrder(repairOrderId);

        RepairOrderDTO repairOrder = controller.findRepairOrder(4004);

        assertTrue(repairOrder.isAccepted(),"Repair order could not be accepted!");
    }


}