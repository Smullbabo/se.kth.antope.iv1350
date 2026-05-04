package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import model.DiagnosticReport;
import model.RepairOrder;

public class RepairOrderRegistryHandlerTest {
    private RepairOrderRegistryHandler registryHandler;

    @BeforeEach
    public void setUp() {
        registryHandler = new RepairOrderRegistryHandler();

    }



    @Test
    public void testCreateRepairOrder() {

        registryHandler.createRepairOrder("problem desc", "123", 000);

        assertNotNull(registryHandler.findRepairOrderFromID(1),"No repair order was created!");
    }

    @Test
    public void testRetriveByPhone() {
        registryHandler.createRepairOrder("problem desc", "123", 000);

        //final Map<Integer, RepairOrder> ordersById = new HashMap<>();

        assertNotNull(registryHandler.findRepairOrderFromPhone("123"),"Could not retrive customer by phone number!");
    }

    @Test
    public void testRetriveById() {
        registryHandler.createRepairOrder("problem desc", "123", 000);

        //final Map<Integer, RepairOrder> ordersById = new HashMap<>();

        assertNotNull(registryHandler.findRepairOrderFromID(1),"Could not retrieve repairORder by Id!");
    }

    @Test
    public void testRetriveBySerial() {
        registryHandler.createRepairOrder("problem desc", "123", 000);

        //final Map<Integer, RepairOrder> ordersById = new HashMap<>();

        assertNotNull(registryHandler.findRepairOrderFromSerial(000),"Could not retrive repair order by serial number");
    }

    @Test
    public void testAddDiagnostic() {
        registryHandler.createRepairOrder("problem desc", "123", 000);


        List<RepairTaskDTO> selectedTasks = new ArrayList<>();
        DiagnosticReport report = new DiagnosticReport("Diag Desc",selectedTasks);
        RepairOrder order = registryHandler.findRepairOrderModelFromID(1);

        order.setDiagnosticReport(report);
        
        RepairOrderDTO orderDTO = order.toDTO();

        assertEquals(true, orderDTO.isReadyForApproval(),"No diagnostic report was created adn therefore isReadyForApproval is not true");
    }
}
