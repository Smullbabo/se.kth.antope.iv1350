package model;

import dto.RepairOrderDTO;

/**
 * A Observer interface for recieving updates about repair orders state. The classes that want this information implments this interface.
 * The observed object must be given a reference to the oberving object. When state changes is the repair order it invokes the
 * reoairOrderUpdate method.
 */
public interface RepairOrderObserver {

    /**
     * Invoked when the state of a repair order changes.
     * @param repairOrder is a DTO of the repair order that changed state.
     */
    void repairOrderUpdate(RepairOrderDTO repairOrder);
}
