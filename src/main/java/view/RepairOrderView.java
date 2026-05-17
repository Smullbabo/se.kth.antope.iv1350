package view;

import dto.RepairOrderDTO;
import model.RepairOrderObserver;

public class RepairOrderView implements RepairOrderObserver{

    @Override
    public void repairOrderUpdate(RepairOrderDTO repairOrder) {
        System.out.println("Repair Order with id: " + repairOrder.getId() + " updated!");
    }
    
}
