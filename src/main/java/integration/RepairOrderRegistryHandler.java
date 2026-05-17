package integration;

import dto.RepairOrderDTO;
import dto.RepairTaskDTO;
import model.RepairOrder;
import model.RepairOrderObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Simulates the regsitry responsible for storing and retrieving repair orders. */
public class RepairOrderRegistryHandler {
    private final Map<Integer, RepairOrder> ordersById = new HashMap<>();
    private int Id = 1;
    private List<RepairOrderObserver> observers = new ArrayList<>();



    /** Creates and stores a new repair order in the map.
     * 
     * Id is generated for each repair order based on previous repair order id.
     * @param problemDescription Customers description of the problem.
     * @param customerPhoneNumber Customers phone number.
     * @param bikeSerialNumber Serial number on the bike.
     */
    public void createRepairOrder(String problemDescription, String customerPhoneNumber, int bikeSerialNumber) {
        int id = Id;
        Id = Id + 1;
        RepairOrder order = new RepairOrder(id, problemDescription, customerPhoneNumber, bikeSerialNumber);
        order.addObservers(observers);
        ordersById.put(id, order);
    }

    /** Finds a repair order from a bike serial number.
     * 
     * @param bikeSerialNumber Serialnumber found on the bike connected to repairorder.
     * @return DTO of the repair order. Null if there is no such repair order.
    */
    public RepairOrderDTO findRepairOrderFromSerial(int bikeSerialNumber) {
        for (RepairOrder order : ordersById.values()) {
            if (order.getBikeSerialNumber() == bikeSerialNumber) {
                return order.toDTO();
            }
        }
        return null;
    }

    /** Finds a repair order from a customer phone number and returns a DTO of that order.
     * 
     * @param phoneNumber Customer phone number.
     * @return DTO of the repair order found.
     */
    public RepairOrderDTO findRepairOrderFromPhone(String phoneNumber) {
        for (RepairOrder order : ordersById.values()) {
            if (order.getCustomerPhoneNumber().equals(phoneNumber)) {
                return order.toDTO();
            }
        }
        return null;
    }

    /** Finds a repair order from the id provided and returns a DTO of that order.
     * 
     * @param repairOrderId id of a desired repair order.
     * @return DTO of the repair order found.
     */
    public RepairOrderDTO findRepairOrderFromID(int repairOrderId) {
        RepairOrder order = ordersById.get(repairOrderId);
        if (order == null) {
            return null;
        }
        return order.toDTO();
    }

    /** Finds the actual repair order object based on the repair order id.
     * 
     * @param repairOrderId Repair order id of the desired repair order.
     * @return Repair order object with id matching params. NULL if no such repair order exists.
     */
    public RepairOrder findRepairOrderModelFromID(int repairOrderId) {
        RepairOrder order = ordersById.get(repairOrderId);
        if (order == null) {
            return null;
        }
        return order;
    }

    /** Adds a diagnostic report to a repair order if the order exists UNUSED.
     * 
     * @param repairOrderId Id of the repair order we want the diagnostic report to be attatched to.
     * @param reportDescription Description from technician.
     * @param selectedTasks Repair Tasks selected by the technican.
     */
    public void addDiagnosticReport(int repairOrderId, String reportDescription, List<RepairTaskDTO> selectedTasks) {
        
        /* 
        RepairOrder order = ordersById.get(repairOrderId);
        if (order != null) {
            DiagnosticReport report = new DiagnosticReport(reportDescription, selectedTasks);
            order.setDiagnosticReport(report);
        }

        */
    } 

    /** Marks a repair order as accepted if the order exists.
     * 
     * @param repairOrderId Id of the repair order we want to mark as accepted.
    */
    public void setAccepted(int repairOrderId) {
        RepairOrder order = ordersById.get(repairOrderId);
        if (order != null) {
            order.setAccepted();
        }
    }

    /**
     * Adds an observer to the List of observers.
     * 
     * @param observer is an observer that observes changes in a repair order.
     */
    public void addObserver(RepairOrderObserver observer) {
        observers.add(observer);
    }
}
