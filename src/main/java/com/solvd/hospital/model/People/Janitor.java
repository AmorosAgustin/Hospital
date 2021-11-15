package com.solvd.hospital.model.People;

import com.solvd.hospital.model.EquipmentAndMachinery.ECG;
import com.solvd.hospital.model.Hospital.Hospital;
import com.solvd.hospital.model.Room.Bedroom;
import com.solvd.hospital.model.Room.Room;

public class Janitor extends Employee implements ITidy {


    public Janitor() {
        super();
    }

    public Janitor(int ID) {
        super(ID);
    }

    public Janitor(String name, String surname, int ID) {
        super(name, surname, ID);
    }

    public Janitor(String name, String surname, int ID, Hospital assignedHospital) {
        super(name, surname, ID, assignedHospital);
    }

    public Janitor(String name, String surname, int ID, Hospital assignedHospital, Room locationRoom) {
        super(name, surname, ID, assignedHospital, locationRoom);
    }


    @Override
    public void tidyRoom(Bedroom bedroom) {
        bedroom.setReadyForUse(true);
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
        Janitor janitor = (Janitor) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }


}
