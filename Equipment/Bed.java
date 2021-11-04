package Equipment;

import Room.Room;

public class Bed extends Equipment {

    private boolean inUse;
    private int inclination;

    public Bed() {
        super();
        this.inUse = false;
        this.inclination = 0;
    }

    public Bed(boolean working, Room locationRoom, int ID, boolean inUse, String type, int inclination) {
        super(working, locationRoom, ID, type);
        this.inUse = inUse;
        if (inclination <= 4)
            this.inclination = inclination;
        else {
            System.out.println("The inclination provided is invalid. It has been set to 0");
            this.inclination = 0;
        }
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int getInclination() {
        return inclination;
    }

    public void setInclination(int inclination) {
        this.inclination = inclination;
    }


}
