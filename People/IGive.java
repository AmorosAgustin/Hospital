package People;

import EquipmentAndMachinery.Equipment;
import Exception.ItemNotFoundException;
import Exception.ItemNotAvailableException;


public interface IGive {

    public abstract Equipment give() throws ItemNotFoundException, ItemNotAvailableException;

}
