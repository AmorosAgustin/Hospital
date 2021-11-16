package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.exception.MachineryBrokenException;

import com.solvd.hospital.model.room.Room;

public abstract class Machinery implements Usable {
    private boolean working;
    private Room locationRoom;
    private int ID;
    private String type;
    private boolean inUse;


    public Machinery() {
        this.working = true;
        this.locationRoom = null;
        this.ID = 0;
        this.type = "empty";
    }

    public Machinery(boolean working, Room locationRoom, int ID, String type, boolean inUse) {
        this.working = working;
        this.locationRoom = locationRoom;
        this.ID = ID;
        this.type = type;
        this.inUse = inUse;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Room getLocationRoom() {
        return locationRoom;
    }

    public void setLocationRoom(Room locationRoom) {
        this.locationRoom = locationRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }


    @Override
    public void use() throws MachineryBrokenException {

        if (!this.working) {
            throw new MachineryBrokenException("This machine is broken, please contact an engineer");
        } else
            this.inUse = true;
    }

    @Override
    public void stopUsing() {
        if (this.inUse)
            this.inUse = false;
    }


    @Override
    public String toString() {
        if (locationRoom != null) {
            return "Type=" + type +
                    ", Room ID= " + locationRoom.getRoomID() +
                    ", Equipment ID=" + ID +
                    ", Working=" + working + '\''
                    + "\n";

        } else {
            return "Type=" + type +
                    ", Room ID= Not located in any room" +
                    ", Equipment ID=" + ID +
                    ", Working=" + working + '\''
                    + "\n";

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machinery machinery = (Machinery) o;
        return ((this.ID == machinery.getID()) && (this.type == machinery.getType()));
    }

    @Override
    public int hashCode() {

        return this.ID;
    }


}
