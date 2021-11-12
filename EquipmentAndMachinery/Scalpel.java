package EquipmentAndMachinery;

import Room.Room;

public class Scalpel extends Equipment {

    public Scalpel(boolean working, Room locationRoom, int ID) {
        super(working, locationRoom, ID, "Scalpel");
    }

    public Scalpel(boolean working, Room locationRoom, int ID, String type) {
        super(working, locationRoom, ID, type);
    }



}
