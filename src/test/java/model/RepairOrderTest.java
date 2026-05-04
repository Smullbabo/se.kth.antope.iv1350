package model;

import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the RepairOrder class.
 */
public class RepairOrderTest {

    /**
     * Tests that a newly created repair order has variables correctly set.
     */
    @Test
    public void testInitialState() {
        RepairOrder order = new RepairOrder(1, "Broken bike", "0701234567", 123);

        RepairOrderDTO dto = order.toDTO();

        assertTrue(dto.isNewlyCreated());
        assertFalse(dto.isReadyForApproval());
        assertFalse(dto.isAccepted());
    }

    /**
     * Tests that adding a diagnostic report updates repair order correctly.
     */
    @Test
    public void testSetDiagnosticReportChangesState() {
        RepairOrder order = new RepairOrder(1, "Broken bike", "0701234567", 123);

        List<RepairTaskDTO> tasks = new ArrayList<>();
        tasks.add(new RepairTaskDTO(1, "Task", "Desc", 100));

        DiagnosticReport report = new DiagnosticReport("Fix needed", tasks);

        order.setDiagnosticReport(report);

        RepairOrderDTO dto = order.toDTO();

        assertFalse(dto.isNewlyCreated());
        assertTrue(dto.isReadyForApproval());
        assertNotNull(dto.getDiagnosticReport());
    }

    /**
     * Tests that accepting the repair order sets accepted to true.
     */
    @Test
    public void testSetAccepted() {
        RepairOrder order = new RepairOrder(1, "Broken bike", "0701234567", 123);

        order.setAccepted();

        RepairOrderDTO dto = order.toDTO();

        assertTrue(dto.isAccepted());
    }

    /**
     * Tests that toDTO correctly creates a DTO.
     */
    @Test
    public void testToDTOTransfersDataCorrectly() {
        RepairOrder order = new RepairOrder(42, "Flat tire", "0709999999", 555);

        RepairOrderDTO dto = order.toDTO();

        assertEquals(42, dto.getId());
        assertEquals("Flat tire", dto.getProblemDescription());
        assertEquals("0709999999", dto.getCustomerPhoneNumber());
        assertEquals(555, dto.getBikeSerialNumber());
    }

    /**
     * Tests that diagnostic report is null if none has been added.
     */
    @Test
    public void testToDTOWIthoutDiagnosticReport() {
        RepairOrder order = new RepairOrder(1, "Broken bike", "0701234567", 123);

        RepairOrderDTO dto = order.toDTO();

        assertNull(dto.getDiagnosticReport());
    }
}