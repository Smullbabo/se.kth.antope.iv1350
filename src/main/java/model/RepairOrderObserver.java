package model;

import dto.RepairOrderDTO;

public interface RepairOrderObserver {


    void repairOrderUpdate(RepairOrderDTO repairOrder);
}
