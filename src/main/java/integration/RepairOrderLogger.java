package integration;

import dto.RepairOrderDTO;
import model.RepairOrderObserver;

/**
 * Observer of repair orders that log the repair order when they change to "System_log.txt".
 */
public class RepairOrderLogger implements RepairOrderObserver{
    private final Logger logger;

    /**
     * Sets a logger for this object
     * @param logger the logger that will write to the spcified file.
     */
    public RepairOrderLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    /**
     * Writes the id of the updated repair order to the file along wiith the complete repair order.
     */
    public void repairOrderUpdate(RepairOrderDTO repairOrder) {
        logger.log("Repair order with id: " + repairOrder.getId() + " updated!");
        logger.log(repairOrder.toString());
    }
    
}
