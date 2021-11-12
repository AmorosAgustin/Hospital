package EquipmentAndMachinery;
import Exception.MachineryBrokenException;

public interface Usable {
    public void use() throws MachineryBrokenException;
    public void stopUsing() throws MachineryBrokenException;

}
