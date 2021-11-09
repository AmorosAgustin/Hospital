package People;

import Room.Room;
import Room.Reception;

import java.util.ArrayList;
import java.util.List;

public class Patient extends People {
    private int insuranceNumber;
    private Room locationRoom;
    private String illness;
    private List<String> medicalHistory;

    public Patient() {
        super();
        this.locationRoom = null;
        this.insuranceNumber = 0000000000;
        this.illness= "unknown";
        this.medicalHistory = new ArrayList<String>();
    }

    public Patient(String name, String surname, int insuranceNumber) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = null;
        this.illness= "unknown";
        this.medicalHistory = new ArrayList<String>();
    }

    public Patient(String name, String surname, int insuranceNumber, Room locationRoom,String illness, List<String>medicalHistory) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = locationRoom;
        this.illness= illness;
        this.medicalHistory = medicalHistory;
    }


    public Patient(String name, String surname, int insuranceNumber, Room locationRoom,String illness) {
        super(name, surname);
        this.insuranceNumber = insuranceNumber;
        this.locationRoom = locationRoom;
        this.illness= illness;
        this.medicalHistory = new ArrayList<String>();
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
    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void printMedicalHistory(){

            System.out.println(this.medicalHistory);

    }
    @Override
    public String toString() {
        if (locationRoom != null) {
            return "Name= '" + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    "Insurance Number= " + insuranceNumber + ", Room= " + locationRoom.getRoomID() +", Illness= "+illness+ "\n";

        } else {
            return "Name= '" + this.getName() + '\'' +
                    ", Surname= '" + this.getSurname() + '\'' +
                    ", Insurance Number= " + insuranceNumber + ", Room= None "+", Illness= "+illness+" \n";
        }
    }


}
