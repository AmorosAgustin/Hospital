package Room;

import Equipment.Bed;
import People.Employee;
import People.Patient;

import java.util.List;

public class IntensiveCareUnit extends Bedroom {

    public IntensiveCareUnit(){
        super();
    }

    public IntensiveCareUnit(int roomID){
        super(roomID);
    }

    public IntensiveCareUnit(List<Employee> assignedEmployee, int roomID, Bed bed) {
        super(assignedEmployee, roomID, bed);
    }
}
