package view;

import dto.RepairOrderDTO;
import model.RepairOrderObserver;

/**
 * Simulated view representing a screen that shows workers at the shop updates on repair orders.
 */
public class RepairOrderView implements RepairOrderObserver{

    @Override
    /**
     * Prints Repair order to SYSOUT when the observer is notified that a change has occured in a repair order.
     */
    public void repairOrderUpdate(RepairOrderDTO repairOrder) {
        System.out.println();
        System.out.println("========== Repair Order View ==========");
        System.out.println(repairOrder);
        System.out.println("=======================================");
        System.out.println();
    }
    
}
