package integration;

import dto.DiagnosticReportDTO;
import dto.RepairOrderDTO;
import dto.RepairTaskDTO;

/** Simulates the object responsible for contacting the printer. */
public class PrinterHandler {
    /** Prints the specified repair order to System.out. (simulating a printing of a physical order.)
     * 
     * @param repairOrder DTO of a repair order to be printed.
     */
    public void printRepairOrder(RepairOrderDTO repairOrder) {
      
        System.out.println("");
        System.out.println("========== PRINTED REPAIR ORDER ==========");
        System.out.println("Order id: " + repairOrder.getId());
        System.out.println("Customer phone: " + repairOrder.getCustomerPhoneNumber());
        System.out.println("Bike serial number: " + repairOrder.getBikeSerialNumber());
        System.out.println("Problem: " + repairOrder.getProblemDescription());
        System.out.println("Accepted: " + repairOrder.isAccepted());
        DiagnosticReportDTO report = repairOrder.getDiagnosticReport();
        System.out.println("Diagnostic report: " + report.getDescription());
            
        for (RepairTaskDTO task : report.getTasks()) {
            System.out.println(" - " + task.getName() + ": " + task.getPrice() + " SEK");
        }
            
        System.out.println("Total cost before discount: " + report.getTotalCost() + " SEK");

        System.out.println("Discounts: " + report.getDiscount() + " SEK");

        System.out.println("Final price after discounts: " + report.getFinalCost() + " SEK");
        
        System.out.println("==========================================");
        System.out.println("");
    }
}
