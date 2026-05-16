package controller;

import dto.CustomerDTO;
import dto.DiagnosticReportDTO;
import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import exceptions.CustomerNotFoundException;
import exceptions.DatabaseFailException;
import integration.CustomerRegistryHandler;
import integration.PrinterHandler;
import integration.RepairOrderRegistryHandler;
import integration.RepairTaskRegistryHandler;
import model.DiagnosticReport;
import model.RepairOrder;

import java.util.List;

/** The controller is the view's connection to the rest of the system. The controller contain references to all other systems. */
public class Controller {
    private final CustomerRegistryHandler customerRegistry;
    private final RepairOrderRegistryHandler repairOrderRegistry;
    private final RepairTaskRegistryHandler repairTaskRegistry;
    private final PrinterHandler printer;

    /** Creates a controller connected to all registies and printer.
     * 
     * @param customerRegistry contains a simulated database with mock data for customers
     * @param repairOrderRegistry contains a simulated database for repair orders.
     * @param repairTaskRegistry contains a simulated database of repair tasks that technician can do.
     * @param printer represents a simulated external printer.
     */
    public Controller(CustomerRegistryHandler customerRegistry,
                      RepairOrderRegistryHandler repairOrderRegistry,
                      RepairTaskRegistryHandler repairTaskRegistry,
                      PrinterHandler printer) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.repairTaskRegistry = repairTaskRegistry;
        this.printer = printer;
    }

    /** Finds a customer in the Customer Registry based on the phone number of a customer.
     * 
     * @param phoneNumber is the customers phoone number.
     * @return CustomerDTO of all the infromation about the customer.
     */
    public CustomerDTO findCustomer(String phoneNumber) throws CustomerNotFoundException{
        return customerRegistry.findCustomer(phoneNumber);
    }

    /** Creates a repair order.
     * 
     * @param problemDescription Description of the problem from the customer.
     * @param customerPhoneNumber CUstomers phone number.
     * @param bikeSerialNumber Serial number on the bike.
     */
    public void createRepairOrder(String problemDescription, String customerPhoneNumber, int bikeSerialNumber) {
        repairOrderRegistry.createRepairOrder(problemDescription, customerPhoneNumber, bikeSerialNumber);
    }

    /** Finds a repair order based on the bike serial number on the bike.
     * 
     * @param bikeSerialNumber Serial number on the bike.
     * @return DTO of a repair order 
     */
    public RepairOrderDTO findRepairOrder(int bikeSerialNumber) {
        return repairOrderRegistry.findRepairOrderFromSerial(bikeSerialNumber);
    }

    /** Finds a repair order based on the phone number of the customer and returns the id of that repair order.
     * 
     * @param phoneNumber CUstomer phone number.
     * @return id of the repair order connected to that customer.
     */
    public int getRepairOrderIdFromPhone(String phoneNumber) {
        RepairOrderDTO repairOrder = repairOrderRegistry.findRepairOrderFromPhone(phoneNumber);
        return repairOrder.getId();
    }

    /** Gets all repair tasks that the technician can select for the diagnostic report.
     * 
     * @return list of repair task that can be done.
     */
    public List<RepairTaskDTO> getAllRepairTasks() {
        return repairTaskRegistry.getAllRepairTasks();
    }

    /** Add diagnostic report to existing repair order.
     * 
     * @param repairOrderId id for the repair order to be modified.
     * @param reportDescription description from the technician for the diagnostic report.
     * @param selectedTasks Tasks selected by the technician to be applied to the order.
     */
    public void addDiagnosticReport(int repairOrderId, String reportDescription, List<RepairTaskDTO> selectedTasks) {
       // repairOrderRegistry.addDiagnosticReport(repairOrderId, reportDescription, selectedTasks);
       RepairOrder repairOrder = repairOrderRegistry.findRepairOrderModelFromID(repairOrderId);
        if (repairOrder != null) {
            DiagnosticReport report = new DiagnosticReport(reportDescription, selectedTasks);
            repairOrder.setDiagnosticReport(report);
        }
       
    }

    /** Gets the diagnostic report for the customer's repair order.
     * 
     * @param customerPhoneNumber Customer phone number.
     * @return Diagnostic Report attatched to the specific repair order.
     */
    public DiagnosticReportDTO getDiagnosticReport(String customerPhoneNumber) {
        RepairOrderDTO order = repairOrderRegistry.findRepairOrderFromPhone(customerPhoneNumber);
        if (order == null) {    
            return null;
        }
        return order.getDiagnosticReport();
    }

    /** Accepts the repair order specified by the id.
     * 
     * @param repairOrderId Id of specified repair order.
     */
    public void acceptRepairOrder(int repairOrderId) {
        repairOrderRegistry.setAccepted(repairOrderId);
    }

    /** Prints the repair order using the printer handler.
     * 
     * @param repairOrderId Id of the specified repair order.
    */
    public void printRepairOrder(int repairOrderId) {
        RepairOrderDTO order = repairOrderRegistry.findRepairOrderFromID(repairOrderId);
        printer.printRepairOrder(order);
    }
}
