package People;

import Room.Room;
import Room.Reception;

public class Patient extends People {
    private int insuranceNumber;
    private Room locationRoom;

    public Patient() {
        super();
        this.locationRoom = null;
        this.insuranceNumber = 0000000000;
    }

    public Patient(String name, String surname, int insuranceNumber) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = null;

    }

    public Patient(String name, String surname, int insuranceNumber, Room locationRoom) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = locationRoom;
    }


    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(int insuranceNumber) {

        this.insuranceNumber = insuranceNumber;

    }


    public Room getLocationRoom() {
        return locationRoom;
    }

    public void setLocationRoom(Room locationRoom) {
        this.locationRoom = locationRoom;
    }

    public void arrive(Reception reception) {
        this.locationRoom = reception;

    }

    public void leave() {
        this.locationRoom = null;

    }

    @Override
    public String toString() {
        if (locationRoom != null) {
            return "Name= '" + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    "Insurance Number= " + insuranceNumber + ", Room= " + locationRoom.getRoomID() + "\n";

        } else {
            return "Name= '" + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    ", Insurance Number= " + insuranceNumber + ", Room= None \n";

        }

    }
}
