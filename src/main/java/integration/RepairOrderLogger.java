package integration;

import dto.RepairOrderDTO;
import model.RepairOrderObserver;

public class RepairOrderLogger implements RepairOrderObserver{
    private final Logger logger;

    public RepairOrderLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void repairOrderUpdate(RepairOrderDTO repairOrder) {
        logger.log("Repair order with id: " + repairOrder.getId() + " updated!");
        logger.log(repairOrder.toString());
    }
    
}
