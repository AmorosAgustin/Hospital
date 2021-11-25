package com.solvd.hospital.model.room;

import com.solvd.hospital.model.equipmentAndMachinery.Bed;
import com.solvd.hospital.model.people.Employee;

import java.util.List;
import java.util.Objects;

public class Bedroom extends Room {

    private Bed bed;
    private boolean readyForUse;

    public Bedroom() {
        super();
        this.bed = null;
        this.readyForUse = true;
    }

    public Bedroom(int roomID) {
        super(roomID);
        this.bed = null;
        this.readyForUse = true;
    }

    public Bedroom(List<Employee> assignedEmployee, int roomID, Bed bed) {
        super(assignedEmployee, roomID);
        this.bed = bed;
        this.readyForUse = true;
    }


    public boolean isReadyForUse() {
        return readyForUse;
    }

    public void setReadyForUse(boolean readyForUse) {
        this.readyForUse = readyForUse;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    @Override
    public String toString() {
        if (this.bed != null) {
            return super.toString() + "Bed ID= " + bed.getID() +
                    ", Ready For Use=" + readyForUse
                    ;
        } else {

            return super.toString() + "Bed ID= No bed assigned" +
                    ", Ready For Use=" + readyForUse
                    ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bedroom bedroom = (Bedroom) o;
        return super.equals(o) && readyForUse == bedroom.readyForUse && Objects.equals(bed, bedroom.bed);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (readyForUse ? 1 : 0) + this.bed.hashCode();
    }
}
