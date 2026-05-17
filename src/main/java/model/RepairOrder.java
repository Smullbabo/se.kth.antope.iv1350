package model;

import java.util.ArrayList;
import java.util.List;

import dto.RepairOrderDTO;

/** Object containing all data and state for the repair order. */
public class RepairOrder {
    private final int id;
    private final String problemDescription;
    private final String customerPhoneNumber;
    private final int bikeSerialNumber;
    private boolean newlyCreated;
    private boolean readyForApproval;
    private boolean accepted;
    private DiagnosticReport diagnosticReport;
    private List<RepairOrderObserver> observers = new ArrayList<>();


   

    /**
     * Adds observer to the list of observers of this object. Also notifies all observers of a change in the repair order (Used when creating the order
     * in order for repair order view to see it when created)
     * @param observers is the observer intreseted in this objects state.
     */
    public void addObservers(List<RepairOrderObserver> observers) {
        this.observers.addAll(observers);
        notifyObservers();
    }

    private void notifyObservers() {

        RepairOrderDTO dto = toDTO();

        for (RepairOrderObserver observer : observers) {
            observer.repairOrderUpdate(dto);
        }
    }

    /** Creates a newly created repair order without a diagnostic report.
     * 
     * @param id Uniqe id generated in the registry 
     * @param problemDescription Customers description of the problem.
     * @param customerPhoneNumber Customers phone number.
     * @param bikeSerialNumber Serial number on the bike.
     */
    public RepairOrder(int id, String problemDescription, String customerPhoneNumber, int bikeSerialNumber) {
        this.id = id;
        this.problemDescription = problemDescription;
        this.customerPhoneNumber = customerPhoneNumber;
        this.bikeSerialNumber = bikeSerialNumber;
        this.newlyCreated = true;
        this.readyForApproval = false;
        this.accepted = false;
    }

    /** Gets the repair order id.
     * 
     * @return repair order id.
     */
    public int getId() { return id; }

    /** Gets the customer's phone number in this order.
     * 
     * @return customer hpone number in the order.
     */
    public String getCustomerPhoneNumber() { return customerPhoneNumber; }

    /** Gets the serial number of the bike in this order.
     * 
     * @return Bike serial number in the order.
     */
    public int getBikeSerialNumber() { return bikeSerialNumber; }

    /** Adds a diagnostic report and changes the state to ready for approval and updates observers.
     * 
     * @param diagnosticReport diagnostic report to be added to the order.
     */
    public void setDiagnosticReport(DiagnosticReport diagnosticReport) {
        this.diagnosticReport = diagnosticReport;
        this.newlyCreated = false;
        this.readyForApproval = true;
        notifyObservers();
    }

    /** Marks this repair order as accepted and updates observers.
     */
    public void setAccepted() {
        this.accepted = true;
        notifyObservers();
    }

    /** Creates a DTO representing this repair order. */
    public RepairOrderDTO toDTO() {
        return new RepairOrderDTO(
                id,
                problemDescription,
                customerPhoneNumber,
                bikeSerialNumber,
                newlyCreated,
                readyForApproval,
                accepted,
                diagnosticReport == null ? null : diagnosticReport.toDTO()
        );
    }
}
