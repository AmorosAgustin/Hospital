package Room;

import People.Employee;
import People.Patient;

import java.util.ArrayList;
import java.util.List;

public class Room {


    private List<Employee> assignedEmployee;
    private int roomID;

    public Room() {
        this.assignedEmployee = new ArrayList<Employee>();
        this.roomID = 00;
    }

    public Room(int roomID)
    {
        this.assignedEmployee=new ArrayList<Employee>();
        this.roomID=roomID;
    }

    public Room(List<Employee> assignedEmployee,int roomID) {
        this.assignedEmployee = assignedEmployee;
        this.roomID = roomID;
    }


    public List<Employee> getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(List<Employee> assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public void printAssignedEmployeeList(){

        if (this.assignedEmployee.size() ==0){
            System.out.println("There are no employees assigned to this room");
        }
        else{
            for(Employee a:this.assignedEmployee){
                a.toString();
            }
        }
    }

    @Override
    public String toString() {
        return  " Room ID= " + roomID+
                ", Assigned Employee= " + assignedEmployee ;
    }
}
