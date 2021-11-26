package com.solvd.hospital.model.people;

import com.solvd.hospital.model.hospital.Hospital;
import com.solvd.hospital.model.room.Reception;
import com.solvd.hospital.model.room.Room;

public abstract class Employee extends People {


    private int ID;
    private Hospital assignedHospital;
    private Room locationRoom;

    public Employee() {
        super();
        this.ID = 0;
    }

    public Employee(int ID) {
        super();
        this.ID = ID;
    }

    public Employee(String name, String surname, int ID) {
        super(name, surname);
        this.ID = ID;
    }


    public Employee(String name, String surname, int ID, Hospital assignedHospital) {
        super(name, surname);
        this.ID = ID;
        this.assignedHospital = assignedHospital;
    }

    public Employee(String name, String surname, int ID, Hospital assignedHospital, Room locationRoom) {
        super(name, surname);
        this.ID = ID;
        this.assignedHospital = assignedHospital;
        this.locationRoom = locationRoom;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Hospital getAssignedHospital() {
        return assignedHospital;
    }

    public void setAssignedHospital(Hospital assignedHospital) {
        this.assignedHospital = assignedHospital;
    }


    public void arrive(Reception reception) {
        this.locationRoom = reception;

    }

    public void leave() {
        this.locationRoom = null;

    }


    public Room getLocationRoom() {
        return locationRoom;
    }

    public void setLocationRoom(Room locationRoom) {
        this.locationRoom = locationRoom;
    }

    @Override
    public String toString() {
        if (this.locationRoom != null) {

            return "Name= " + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    ", ID= " + ID + ", Room ID= " + locationRoom.getRoomID();
        } else {
            return "Name= " + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    ", ID= " + ID + ", Room ID= Not in a room right now";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return this.ID == employee.ID;
    }

    @Override
    public int hashCode() {

        return super.hashCode() * ID;
    }


}
