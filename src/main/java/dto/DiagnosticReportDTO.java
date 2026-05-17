package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** DTO for a diagnostic report for the customer. */
public class DiagnosticReportDTO {
    private final String description;
    private final List<RepairTaskDTO> tasks;
    private final double totalCost;
    private final double finalCost;
    private final double discount;

    /** Creates a DTO containing diagnostic report data.
     * 
     * @param description description of diagnostic
     * @param tasks list of repair tasks selected
     * @param totalCost total cost of all repair tasks
     */
    public DiagnosticReportDTO(String description, List<RepairTaskDTO> tasks, double totalCost, double finalCost, double discount) {
        this.description = description;
        this.tasks = new ArrayList<>(tasks);
        this.totalCost = totalCost;
        this.finalCost = finalCost;
        this.discount = discount;
    }

    /** Gets the description. */
    public String getDescription() { return description; }

    /** Gets the repair tasks for the report. */
    public List<RepairTaskDTO> getTasks() { return Collections.unmodifiableList(tasks); }

    /** Gets the total cost of all tasks */
    public double getTotalCost() { return totalCost; }

     /** Gets the total cost of all tasks */
    public double getFinalCost() { return finalCost; }

     /** Gets the total cost of all tasks */
    public double getDiscount() { return discount; }



}
