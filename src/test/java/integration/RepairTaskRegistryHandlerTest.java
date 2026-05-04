package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.RepairTaskDTO;

public class RepairTaskRegistryHandlerTest {
    private RepairTaskRegistryHandler repairRegistry;

    @BeforeEach
    public void setUp() {
        repairRegistry = new RepairTaskRegistryHandler();
    }


    @Test
    public void testRetrieveTasks() {
        List<RepairTaskDTO> allTasks = repairRegistry.getAllRepairTasks();

        assertNotNull(allTasks);
        assertEquals("Battery diagnosis", allTasks.get(0).getName());
        assertEquals("Tire replacement", allTasks.get(3).getName());
    }
}
