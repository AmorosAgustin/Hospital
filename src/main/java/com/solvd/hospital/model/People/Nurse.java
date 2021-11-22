package com.solvd.hospital.model.people;

import com.solvd.hospital.model.equipmentAndMachinery.Equipment;
import com.solvd.hospital.model.exception.ItemNotAvailableException;
import com.solvd.hospital.model.exception.ItemNotFoundException;
import com.solvd.hospital.model.exception.PersonNotInDatabaseException;
import com.solvd.hospital.model.hospital.Hospital;
import com.solvd.hospital.model.medicine.Medicine;
import com.solvd.hospital.model.room.Bedroom;
import com.solvd.hospital.model.room.Room;

import java.util.List;
import java.util.Objects;

public class Nurse extends Employee implements IPrescribe, ITidy, IAskFor, IGive {

    private Equipment equipmentInUse;


    public Nurse() {
        super();
    }

    public Nurse(int ID) {
        super(ID);
    }

    public Nurse(String name, String surname, int ID, Hospital assignedHospital) {
        super(name, surname, ID, assignedHospital);
    }

    public Nurse(String name, String surname, int ID, Hospital assignedHospital, Room locationRoom, Equipment equipmentInUse) {
        super(name, surname, ID, assignedHospital, locationRoom);
        this.equipmentInUse = equipmentInUse;
    }


    public Equipment getEquipmentInUse() {
        return equipmentInUse;
    }

    public void setEquipmentInUse(Equipment equipmentInUse) {
        this.equipmentInUse = equipmentInUse;
    }


    public void movePatient(Patient patient, Room room) {
        if (patient.getLocationRoom() != null) {
            if (patient.getLocationRoom() instanceof Bedroom) {
                ((Bedroom) patient.getLocationRoom()).getBed().setInUse(false);
            }
        }


        patient.setLocationRoom(room);
        if (room instanceof Bedroom) {
            ((Bedroom) room).getBed().setInUse(true);
            ((Bedroom) room).setReadyForUse(false);
        }

    }

    @Override
    public void askForItem(Employee employee) {


        if ((employee instanceof Receptionist)) {
            throw new ItemNotFoundException("This employee has no items");
        } else if ((employee instanceof Nurse) && (((Nurse) employee).getEquipmentInUse() != null)) {
            this.setEquipmentInUse(((Nurse) employee).give());
        } else if ((employee instanceof Doctor) && (((Doctor) employee).getEquipmentInUse() != null)) {
            this.setEquipmentInUse(((Doctor) employee).give());
        }
    }


    public List<String> askForMedicalHistory(Employee employee, Patient patient) {

        if (employee instanceof Receptionist) {

            if (((Receptionist) employee).getPatientMedicalHistory(patient) != null) {
                return ((Receptionist) employee).getPatientMedicalHistory(patient);
            } else {
                throw new PersonNotInDatabaseException("This patient is not registered in the database");
            }
        }
        return null;
    }

    public Equipment give() {

        if (this.equipmentInUse == null) {
            throw new ItemNotFoundException("This employee has no items right now");
        }
        if (!this.equipmentInUse.isAvailable()) {
            throw new ItemNotAvailableException("This item is already being used");
        }
        Equipment equip = this.equipmentInUse;
        this.setEquipmentInUse(null);
        return equip;
    }

    @Override
    public void prescribe(Medicine medicine, Patient patient) {

        patient.setPrescribedMedicine(medicine);

    }

    @Override
    public void tidyRoom(Bedroom bedroom) {

        bedroom.setReadyForUse(true);
    }

    @Override
    public String toString() {
        if (this.equipmentInUse != null)

            return super.toString() + " Using = " + equipmentInUse.getType() + "\n";
        else {

            return super.toString() + " Using = Nothing" + "\n"
                    ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nurse nurse = (Nurse) o;
        return super.equals(o) && Objects.equals(equipmentInUse, nurse.equipmentInUse);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (equipmentInUse != null ? equipmentInUse.hashCode() : 0);
    }
}
