package com.solvd.hospital.model.room;

import com.solvd.hospital.model.people.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {

    private static final Logger log = LogManager.getLogger(Room.class);


    private List<Employee> assignedEmployee;
    private int roomID;

    public Room() {
        this.assignedEmployee = new ArrayList<Employee>();
        this.roomID = 00;
    }

    public Room(int roomID) {
        this.assignedEmployee = new ArrayList<Employee>();
        this.roomID = roomID;
    }

    public Room(List<Employee> assignedEmployee, int roomID) {
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

    public void printAssignedEmployeeList() {

        if (this.assignedEmployee.size() == 0) {
            log.info("There are no employees assigned to this room");
        } else {
            for (Employee a : this.assignedEmployee) {
                a.toString();
            }
        }
    }

    @Override
    public String toString() {
        return "\n Room ID= " + roomID + "\n" +
                ", --Assigned Employee-- " + "\n" + assignedEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomID == room.roomID && Objects.equals(assignedEmployee, room.assignedEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignedEmployee, roomID);
    }
}
