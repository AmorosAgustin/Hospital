package com.solvd.hospital.model.generic;

import com.solvd.hospital.model.equipmentAndMachinery.Equipment;
import com.solvd.hospital.model.equipmentAndMachinery.Machinery;
import com.solvd.hospital.model.people.Employee;
import com.solvd.hospital.model.people.Patient;
import com.solvd.hospital.model.room.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoveObject<U> {

    private final static Logger log = LogManager.getLogger(MoveObject.class);

    public void move(U u, Room room) {
        log.info("Here i move the object to the desired room");

        if (u instanceof Machinery) {
            ((Machinery) u).setLocationRoom(room);
        } else if (u instanceof Patient) {
            ((Patient) u).setLocationRoom(room);
        } else if (u instanceof Employee) {
            ((Employee) u).setLocationRoom(room);
        } else if (u instanceof Equipment) {
            ((Equipment) u).setLocationRoom(room);
        } else {
            log.info("This object is not movable");
        }


    }
}
