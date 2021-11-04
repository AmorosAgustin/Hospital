package Room;

import Equipment.Equipment;
import People.Employee;

import java.util.List;

public class ExamRoom extends Room {


    private Equipment assignedEquipment;

    public ExamRoom() {
        super();
        this.assignedEquipment = null;
    }

    public ExamRoom(int roomID) {
        super(roomID);
        this.assignedEquipment = null;
    }

    public ExamRoom(Equipment assignedEquipment) {
        super();
        this.assignedEquipment = assignedEquipment;
    }

    public ExamRoom(List<Employee> assignedEmployee, int roomID, Equipment assignedEquipment) {
        super(assignedEmployee, roomID);
        this.assignedEquipment = assignedEquipment;
    }


    public Equipment getAssignedEquipment() {
        return assignedEquipment;
    }

    public void setAssignedEquipment(Equipment assignedEquipment) {
        this.assignedEquipment = assignedEquipment;

    }
}
