package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.exception.MachineryBrokenException;
import com.solvd.hospital.model.room.Room;

public class Scalpel extends Equipment {
    private static final int MAX_TIMES_OF_USAGE=10;

    int timesUsed;

    public Scalpel(boolean working, Room locationRoom, int ID) {
        super(working, locationRoom, ID, "Scalpel");
    }

    public Scalpel(boolean working, Room locationRoom, int ID, String type) {
        super(working, locationRoom, ID, type);
    }


    @Override
    public void use() {
        if(timesUsed<MAX_TIMES_OF_USAGE){
            super.use();
            timesUsed++;
        }
        else{
        throw new MachineryBrokenException("The scalpel is broken and can't be used.");
        }

    }
}
