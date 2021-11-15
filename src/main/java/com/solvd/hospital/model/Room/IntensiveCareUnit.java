package com.solvd.hospital.model.Room;

import com.solvd.hospital.model.EquipmentAndMachinery.Bed;
import com.solvd.hospital.model.People.Employee;

import java.util.List;

public class IntensiveCareUnit extends Bedroom {

    public IntensiveCareUnit() {
        super();
    }

    public IntensiveCareUnit(int roomID) {
        super(roomID);
    }

    public IntensiveCareUnit(List<Employee> assignedEmployee, int roomID, Bed bed) {
        super(assignedEmployee, roomID, bed);
    }
}
