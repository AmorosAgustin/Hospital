package Room;

import Equipment.Bed;
import People.Employee;

import java.util.List;

public class Bedroom extends Room{

    private Bed bed;

    public Bedroom (){
        super();
        this.bed=null;
    }

    public Bedroom (int roomID){
        super(roomID);
        this.bed=null;
    }

    public Bedroom(List<Employee> assignedEmployee, int roomID, Bed bed) {
        super(assignedEmployee, roomID);
        this.bed = bed;
    }



    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
