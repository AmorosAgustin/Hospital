package com.solvd.hospital.model.room;

import com.solvd.hospital.model.people.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {


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
            System.out.println("There are no employees assigned to this room");
        } else {
            for (Employee a : this.assignedEmployee) {
                a.toString();
            }
        }
    }

    @Override
    public String toString() {
        return " Room ID= " + roomID +
                ", Assigned Employee= " + assignedEmployee + "";
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
