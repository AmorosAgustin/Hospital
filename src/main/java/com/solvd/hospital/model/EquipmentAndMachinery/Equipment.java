package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.room.Room;

public abstract class Equipment implements Usable {


    private boolean available;
    private Room locationRoom;
    private int ID;
    private String type;


    public Equipment() {
        this.available = true;
        this.locationRoom = null;
        this.ID = 0;
        this.type = "empty";
    }

    public Equipment(boolean available, Room locationRoom, int ID, String type) {
        this.available = available;
        this.locationRoom = locationRoom;
        this.ID = ID;
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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


    @Override
    public void use() {

        this.available = false;

    }

    public void stopUsing() {

        this.available = false;
    }


    @Override
    public String toString() {
        if (locationRoom != null) {
            return "Type=" + type +
                    ", Room ID= " + locationRoom.getRoomID() +
                    ", Equipment ID=" + ID +
                    ", Available=" + available + '\''
                    + "\n";

        } else {
            return "Type=" + type +
                    ", Room ID= Not located in any room" +
                    ", Equipment ID=" + ID +
                    ", Available=" + available + '\''
                    + "\n";

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return ((this.ID == equipment.getID()) && (this.type == equipment.getType()));
    }

    @Override
    public int hashCode() {
        return this.ID;
    }


}
