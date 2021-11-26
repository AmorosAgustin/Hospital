package com.solvd.hospital.model.people;

import com.solvd.hospital.model.exception.PersonAlreadyInDatabaseException;
import com.solvd.hospital.model.exception.PersonNotInDatabaseException;
import com.solvd.hospital.model.exception.QueueIsEmptyException;
import com.solvd.hospital.model.hospital.Hospital;
import com.solvd.hospital.model.room.Reception;
import com.solvd.hospital.model.room.Room;

import java.util.List;

public class Receptionist extends Employee {


    public Receptionist() {
        super();
    }

    public Receptionist(int ID) {
        super(ID);
    }

    public Receptionist(String name, String surname, int ID, Hospital assignedHospital) {
        super(name, surname, ID, assignedHospital);
    }


    public Receptionist(String name, String surname, int ID, Hospital assignedHospital, Room locationRoom) {
        super(name, surname, ID, assignedHospital, locationRoom);
    }

    public void assignNextPatientToRoom(Room room) {

        if (this.getLocationRoom() instanceof Reception)

            if (((Reception) this.getLocationRoom()).getPatientsQueue().peek() != null) {
                ((Reception) this.getLocationRoom()).getPatientsQueue().peek().setLocationRoom(room);
                ((Reception) this.getLocationRoom()).getPatientsQueue().remove();
            } else throw new QueueIsEmptyException("The queue is empty");


    }

    public void addToPatientList(Patient patient) {
        if (this.getAssignedHospital().getDatabase().getPatientList().contains(patient)) {
            throw new PersonAlreadyInDatabaseException("This patient is already registered");
        } else {
            this.getAssignedHospital().getDatabase().getPatientList().add(patient);
        }


    }

    public void removeFromPatientList(Patient patient) {

        if (!(this.getAssignedHospital().getDatabase().getPatientList().contains(patient))) {
            throw new PersonNotInDatabaseException("This patient is not registered in the database");
        } else {
            this.getAssignedHospital().getDatabase().getPatientList().remove(patient);
        }


    }

    public void addToEmployeeList(Employee employee) {
        if (this.getAssignedHospital().getDatabase().getEmployeeList().contains(employee)) {
            throw new PersonAlreadyInDatabaseException("This employee is already registered");
        } else {
            this.getAssignedHospital().getDatabase().getEmployeeList().add(employee);
        }

    }

    public void removeFromEmployeeList(Employee employee) {
        if (!(this.getAssignedHospital().getDatabase().getEmployeeList().contains(employee))) {
            throw new PersonNotInDatabaseException("This employee is not registered in the database");
        } else {
            this.getAssignedHospital().getDatabase().getEmployeeList().remove(employee);
        }

    }


    public List<String> getPatientMedicalHistory(Patient patient) {

        if (this.getAssignedHospital().getDatabase().getPatientList().contains(patient))
            return patient.getMedicalHistory();
        else {
            throw new PersonNotInDatabaseException("This patient is not registered in the database");
        }

    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Receptionist receptionist = (Receptionist) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }


}
