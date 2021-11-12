package People;

import EquipmentAndMachinery.Equipment;
import Exception.ItemNotFoundException;
import Exception.PersonNotInDatabaseException;
import Exception.ItemNotAvailableException;

import java.util.List;

public interface IAskFor {

    public abstract void askForItem(Employee employee) throws ItemNotFoundException, ItemNotAvailableException;

    public abstract List<String> askForMedicalHistory(Employee employee, Patient patient) throws PersonNotInDatabaseException;


}
