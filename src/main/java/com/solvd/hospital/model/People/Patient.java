package com.solvd.hospital.model.People;

import com.solvd.hospital.model.Medicine.Medicine;
import com.solvd.hospital.model.Room.Room;
import com.solvd.hospital.model.Room.Reception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends People {
    private String insuranceNumber;
    private Room locationRoom;
    private String illness;
    private List<String> medicalHistory;
    private Medicine prescribedMedicine;

    public Patient() {
        super();
        this.locationRoom = null;
        this.insuranceNumber = "00000000";
        this.illness = "unknown";
        this.medicalHistory = new ArrayList<String>();
    }

    public Patient(String name, String surname, String insuranceNumber) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = null;
        this.illness = "unknown";
        this.medicalHistory = new ArrayList<String>();
    }

    public Patient(String name, String surname, String insuranceNumber, Room locationRoom, String illness, List<String> medicalHistory) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = locationRoom;
        this.illness = illness;
        this.medicalHistory = medicalHistory;
    }


    public Patient(String name, String surname, String insuranceNumber, Room locationRoom, String illness) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = locationRoom;
        this.illness = illness;
        this.medicalHistory = new ArrayList<String>();
    }


    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {

        this.insuranceNumber = insuranceNumber;

    }


    public Room getLocationRoom() {
        return locationRoom;
    }

    public void setLocationRoom(Room locationRoom) {
        this.locationRoom = locationRoom;
    }

    public void arrive(Reception reception) {
        this.locationRoom = reception;

    }

    public void leave() {
        this.locationRoom = null;

    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void printMedicalHistory() {

        System.out.println(this.medicalHistory);

    }

    public Medicine getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(Medicine prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }


    @Override
    public String toString() {
        if (locationRoom != null) {
            return "Name= " + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    "Insurance Number= " + insuranceNumber + ", Room= " + locationRoom.getRoomID() + ", Illness= " + illness + ", Prescribed Medicine= " + prescribedMedicine + " \n";

        } else {
            return "Name= " + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    ", Insurance Number= " + insuranceNumber + ", Room= None " + ", Illness= " + illness + ", Prescribed Medicine= " + prescribedMedicine + " \n";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(insuranceNumber, patient.insuranceNumber) && Objects.equals(locationRoom, patient.locationRoom) && Objects.equals(illness, patient.illness) && Objects.equals(medicalHistory, patient.medicalHistory) && Objects.equals(prescribedMedicine, patient.prescribedMedicine);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + insuranceNumber.hashCode() + locationRoom.hashCode() + illness.hashCode() + medicalHistory.hashCode() + prescribedMedicine.hashCode();
    }
}
