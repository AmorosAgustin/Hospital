package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.room.Room;

public class ECG extends Machinery {


    public ECG() {
        super();
    }

    public ECG(boolean working, Room locationRoom, int ID, String type, boolean state) {
        super(working, locationRoom, ID, type, state);
    }


    @Override
    public String toString() {
        return "Working=" + this.isWorking() +
                ", Room ID= " + this.getLocationRoom().getRoomID() +
                ", Equipment ID=" + this.getID() +
                ", Type='" + this.getType() + '\'' + ",  In Use=" + this.isInUse() +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ECG ecg = (ECG) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }


}
