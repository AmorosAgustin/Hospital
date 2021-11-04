package Equipment;

import Room.Room;

public abstract class Equipment {

    private boolean working;
    private Room locationRoom;
    private int ID;
    private String type;


    public Equipment() {
        this.working = true;
        this.locationRoom = null;
        this.ID = 000000;
        this.type = "empty";
    }

    public Equipment(boolean working, Room locationRoom, int ID, String type) {
        this.working = working;
        this.locationRoom = locationRoom;
        this.ID = ID;
        this.type = type;
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

    @Override
    public String toString() {
        return "Working=" + working +
                ", Room ID= " + locationRoom.getRoomID() +
                ", Equipment ID=" + ID +
                ", Type='" + type + '\''
                + "\n";
    }

}
