package com.solvd.hospital.model.Room;

import com.solvd.hospital.model.People.Employee;

import java.util.List;

public class Reception extends Room {

    public Reception() {
        super();
    }

    public Reception(int roomID) {
        super(roomID);
    }

    public Reception(List<Employee> assignedEmployee, int roomID) {
        super(assignedEmployee, roomID);
    }
}
