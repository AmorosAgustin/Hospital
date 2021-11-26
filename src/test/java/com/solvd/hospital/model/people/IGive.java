package com.solvd.hospital.model.people;

import com.solvd.hospital.model.equipmentAndMachinery.Equipment;
import com.solvd.hospital.model.exception.ItemNotAvailableException;
import com.solvd.hospital.model.exception.ItemNotFoundException;


public interface IGive {

    Equipment give() throws ItemNotFoundException, ItemNotAvailableException;

}
