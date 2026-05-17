package view;

import controller.Controller;
import dto.CustomerDTO;
import dto.DiagnosticReportDTO;
import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import exceptions.CustomerNotFoundException;
import exceptions.DatabaseFailException;
import integration.Logger;
import integration.LoggerToFile;
import integration.RepairOrderLogger;

import java.util.ArrayList;
import java.util.List;

/** 
 * Simulated view that represent the UI. Hard coded calls representing the basic flow.
*/
public class View {
    private final Controller controller;
    private Logger logger;

    /** Creates a view with a reference to a specific controller.
     * 
     * @param controller is specific controller that the view communicates through.
     */
    public View(Controller controller) {
        this.controller = controller;
        controller.addRepairOrderObserver(new RepairOrderView());
        controller.addRepairOrderObserver(new RepairOrderLogger(new LoggerToFile()));
    }

    /**
     * Sets a the views logger to specified logger.
     * @param logger logs things to "System_log.txt"
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /** Runs a basic demo of all of the calls featured in the basic flow of the electric bike repair shop scenario.
     * 
     */
    public void runDemoExecution() {


        // Simulate customer giving their phone number.
        String phoneNumber = "0701234567";

        // First system call, find customer from given phone number.
        CustomerDTO customer;
        try {
            customer = controller.findCustomer(phoneNumber);
        } catch (CustomerNotFoundException e) {
            System.out.println("No customer found for phone number: " + phoneNumber);
            return;
        } catch (DatabaseFailException e) {
            System.out.println("Something went wrong. Try again later!");
            logger.log("Database faliure: " + e.getMessage());
            return;
        }
        System.out.println("Found customer:" + customer);

        // Second system call, create a repair order with simulated problem description from customer, their phonenumber and the serialnumber found in the registry.
        controller.createRepairOrder("Battery does not charge and brakes feel weak.", phoneNumber, customer.getBikeSerialNumber());
        System.out.println("Created repair order!");

        // Third sytem call, technican retrieves the repair order for the bike using the serialnumber on the bike.
        RepairOrderDTO order = controller.findRepairOrder(customer.getBikeSerialNumber());
        System.out.println("Technician found order!");

        // Fourth system call, technician retrieves the possible repairtasks from the repair task registry.
        List<RepairTaskDTO> allTasks = controller.getAllRepairTasks();
        System.out.println("Available tasks:");
        for (RepairTaskDTO task : allTasks) {
            System.out.println(task);
        }

        // Simulate technician selecting relevant repairtasks during the diagnostic.
        List<RepairTaskDTO> selectedTasks = new ArrayList<>();
        selectedTasks.add(allTasks.get(0));
        selectedTasks.add(allTasks.get(1));
        
        // FIfth system call, technican adds diagnostic report to the repair order with given id, description of the problems and the list of selected repair tasks.
        controller.addDiagnosticReport(order.getId(), "Battery is weak and brakes need adjustment.", selectedTasks);
        System.out.println("Diagnostic report added.");

        // Sixth system call, receptionist retrieves the diagnostic report using the customers phone number for the customer to approve.
        DiagnosticReportDTO report = controller.getDiagnosticReport(phoneNumber);
        System.out.println("Report for customer approval: " + report);

        // Seventh system call, after customer review they accept the proposed changes. Repair order is accepted.
        int repairOrderId = controller.getRepairOrderIdFromPhone(phoneNumber);
        controller.acceptRepairOrder(repairOrderId);
        System.out.println("Customer accepted the repair order.");

        // Final system call, after being accepted the receptionist prints the repair order for the customer.
        controller.printRepairOrder(repairOrderId);
    }
}
