package Hospital;

import Equipment.Equipment;
import Room.Room;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Room> rooms;
    private Database database;
    private List<Equipment> equipment;


    public Hospital(){
        this.rooms = new ArrayList<Room>();
        this.database = new Database();
        this.equipment = new ArrayList<Equipment>();
    }
    public Hospital(List<Room> rooms, Database database, List<Equipment> equipment) {
        this.rooms = rooms;
        this.database = database;
        this.equipment = equipment;
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

    @Override
    public String toString() {


        return "Hospital" + "\n" +
                "Rooms=" + "\n" + rooms  + "\n" +
                ", Database= "  + "\n" + database  + "\n" +
                ", Equipment= "  + "\n" + equipment  + "\n" +
                '}';
    }



}
