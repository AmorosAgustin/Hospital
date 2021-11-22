package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.exception.MachineryBrokenException;
import com.solvd.hospital.model.room.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scalpel extends Equipment {
    private static final int MAX_TIMES_OF_USAGE = 10;

    private static final Logger log = LogManager.getLogger(Scalpel.class);

    int timesUsed;

    public Scalpel(boolean working, Room locationRoom, int ID) {
        super(working, locationRoom, ID, "Scalpel");
    }

    public Scalpel(boolean working, Room locationRoom, int ID, String type) {
        super(working, locationRoom, ID, type);
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public void repair() {
        if (this.getTimesUsed() < MAX_TIMES_OF_USAGE) {
            log.info("This scalpel is not broken");
        } else {
            this.setTimesUsed(0);
            log.info("The scalpel has been repaired successfully");
        }

    }

    @Override
    public void use() {
        if (timesUsed < MAX_TIMES_OF_USAGE) {
            super.use();
            timesUsed++;
        } else {
            throw new MachineryBrokenException("The scalpel is broken and can't be used.");
        }

    }


    @Override
    public String toString() {
        return super.toString() +
                ", Times used= " + timesUsed
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Scalpel scalpel = (Scalpel) o;
        return timesUsed == scalpel.timesUsed && super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getTimesUsed();
    }
}
