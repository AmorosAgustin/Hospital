package People;

import Room.Room;
import Room.Bedroom;
import Room.IntensiveCareUnit;

public class Nurse extends Employee {

    public Nurse() {
        super();
    }

    public Nurse(int ID) {
        super(ID);
    }

    public Nurse(String name, String surname, int ID) {
        super(name, surname, ID);
    }

    public void movePatient(Patient patient, Room room) {
        if (patient.getLocationRoom() != null) {
            if (patient.getLocationRoom() instanceof Bedroom) {
                ((Bedroom) patient.getLocationRoom()).getBed().setInUse(false);
            }
        }


        patient.setLocationRoom(room);
        if (room instanceof Bedroom) {
            ((Bedroom) room).getBed().setInUse(true);
        }

    }
}
