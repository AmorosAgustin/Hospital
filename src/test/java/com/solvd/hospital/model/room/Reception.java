package com.solvd.hospital.model.room;

import com.solvd.hospital.model.people.Employee;
import com.solvd.hospital.model.people.Patient;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reception extends Room {

    private Queue<Patient> patientsQueue;


    public Reception() {
        super();
        this.patientsQueue = new LinkedList<Patient>();
    }


    public Reception(int roomID) {
        super(roomID);
        this.patientsQueue = new LinkedList<Patient>();
    }

    public Reception(List<Employee> assignedEmployee, int roomID) {
        super(assignedEmployee, roomID);
        this.patientsQueue = new LinkedList<Patient>();
    }

    public Queue<Patient> getPatientsQueue() {
        return patientsQueue;
    }

    public void setPatientsQueue(Queue<Patient> patientsQueue) {
        this.patientsQueue = patientsQueue;
    }

    @Override
    public String toString() {
        return super.toString() +
                " ---Patients waiting--- " + "\n" + patientsQueue + "\n";
    }
}
