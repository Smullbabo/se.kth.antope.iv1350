package integration;

import dto.RepairTaskDTO;
import java.util.ArrayList;
import java.util.List;

/** Simulates the class retrieving predefined repair tasks. */
public class RepairTaskRegistryHandler {
    private static final RepairTaskRegistryHandler INSTANCE = new RepairTaskRegistryHandler();


    private final List<RepairTaskDTO> repairTasks = new ArrayList<>();

    /** Creates the registry handler and fills it with simulated repair tasks. */
    private RepairTaskRegistryHandler() {
        repairTasks.add(new RepairTaskDTO(1, "Battery diagnosis", "Test battery capacity and charging behavior", 499));
        repairTasks.add(new RepairTaskDTO(2, "Brake adjustment", "Adjust and test front and rear brakes", 299));
        repairTasks.add(new RepairTaskDTO(3, "Motor inspection", "Inspect motor, cables and controller", 699));
        repairTasks.add(new RepairTaskDTO(4, "Tire replacement", "Replace damaged tire", 399));
    }

    public static RepairTaskRegistryHandler getInstance() {
        return INSTANCE;
    }

    /** Gets all predefined repair tasks.
     * 
     * @return Collection of all repair task in the registry.
     */
    public List<RepairTaskDTO> getAllRepairTasks() {
        return new ArrayList<>(repairTasks);
    }
}
