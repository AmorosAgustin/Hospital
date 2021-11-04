package Equipment;

import Room.Room;

import java.util.Objects;

public class ECG extends Equipment {


    private boolean state;

    public ECG() {
        super();
        this.state = false;
    }

    public ECG(boolean working, Room locationRoom, int ID, String type, boolean state) {
        super(working, locationRoom, ID, type);
        this.state = state;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void turnOn() {
        this.setState(true);
    }

    public void turnOff() {
        this.setState(false);
    }

    @Override
    public String toString() {
        return "Working=" + this.isWorking() +
                ", Room ID= " + this.getLocationRoom().getRoomID() +
                ", Equipment ID=" + this.getID() +
                ", Type='" + this.getType() + '\'' + "State=" + state +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ECG ecg = (ECG) o;
        return isState() == ecg.isState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isState());
    }
}
