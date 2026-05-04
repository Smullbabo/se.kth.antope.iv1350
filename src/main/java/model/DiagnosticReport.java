package model;

import dto.DiagnosticReportDTO;
import dto.RepairTaskDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Object representing the technicians diagnostic report */
public class DiagnosticReport {
    private final String description;
    private final List<RepairTaskDTO> tasks;
    private final double totalCost;

    /** Creates a diagnostic report from a description and selected tasks.
     * 
     * @param description Description of the diagnostic by the technician
     * @param tasks List of selected repair task by the technician
     */
    public DiagnosticReport(String description, List<RepairTaskDTO> tasks) {
        this.description = description;
        this.tasks = new ArrayList<>(tasks);
        this.totalCost = calculateCost();
    }

    private double calculateCost() {
        double sum = 0;
        for (RepairTaskDTO task : tasks) {
            sum = sum + task.getPrice();
        }
        return sum;
    }

    /** Gets the report description. */
    public String getDescription() { return description; }

    /** Gets the repair tasks included in the report. */
    public List<RepairTaskDTO> getTasks() { return new ArrayList<>(tasks); }

    /** Gets the calculated total cost. */
    public double getTotalCost() { return totalCost; }

    /** Creates a DTO representing this diagnostic report. */
    public DiagnosticReportDTO toDTO() {
        return new DiagnosticReportDTO(description, tasks, totalCost);
    }
}
