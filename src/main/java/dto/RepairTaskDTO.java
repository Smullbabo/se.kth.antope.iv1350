package dto;

/** Immutable DTO for a possible repair task. */
public class RepairTaskDTO {
    private final int taskId;
    private final String name;
    private final String description;
    private final double price;

    /** Creates a DTO containing the visible data for one repair task. */
    public RepairTaskDTO(int taskId, String name, String description, double price) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /** Gets the task id. */
    public int getTaskId() { return taskId; }

    /** Gets the task name. */
    public String getName() { return name; }

    /** Gets the task description. */
    public String getDescription() { return description; }

    /** Gets the task price. */
    public double getPrice() { return price; }


    @Override
    /**
     * Creates a string representation of a repair task.
     */
    public String toString() {
        return
            "\n Task Id: " + taskId +
            "\n Task Name: " + name + 
            "\n Price: " + price;
    }

}
