package com.solvd.hospital.model.People;

import com.solvd.hospital.model.EquipmentAndMachinery.Equipment;
import com.solvd.hospital.model.Exception.ItemNotFoundException;
import com.solvd.hospital.model.Exception.ItemNotAvailableException;


public interface IGive {

    public abstract Equipment give() throws ItemNotFoundException, ItemNotAvailableException;

}
