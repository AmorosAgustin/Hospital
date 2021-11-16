package com.solvd.hospital.model.hospital;

import com.solvd.hospital.model.equipmentAndMachinery.Equipment;
import com.solvd.hospital.model.equipmentAndMachinery.Machinery;
import com.solvd.hospital.model.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospital {
    private List<Room> rooms;
    private Database database;
    private List<Equipment> equipment;
    private List<Machinery> machinery;

    public Hospital() {
        this.rooms = new ArrayList<Room>();
        this.database = new Database();
        this.equipment = new ArrayList<Equipment>();
        this.machinery = new ArrayList<Machinery>();
    }

    public Hospital(List<Room> rooms, Database database, List<Equipment> equipment, List<Machinery> machinery) {
        this.rooms = rooms;
        this.database = database;
        this.equipment = equipment;
        this.machinery = machinery;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }


    public List<Machinery> getMachinery() {
        return machinery;
    }

    public void setMachinery(List<Machinery> machinery) {
        this.machinery = machinery;
    }

    @Override
    public String toString() {


        return "Hospital" + "\n" +
                ", Rooms=" + "\n" + rooms + "\n" +
                ", Database= " + "\n" + database + "\n" +
                ", Equipment= " + "\n" + equipment + "\n" + ", Machinery= " + machinery + "\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(rooms, hospital.rooms) && Objects.equals(database, hospital.database) && Objects.equals(equipment, hospital.equipment) && Objects.equals(machinery, hospital.machinery);
    }

    @Override
    public int hashCode() {
        return rooms.hashCode() * database.hashCode() * equipment.hashCode() * machinery.hashCode();
    }
}
