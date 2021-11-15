package com.solvd.hospital.model.People;

import com.solvd.hospital.model.Exception.ItemNotAvailableException;
import com.solvd.hospital.model.Exception.ItemNotFoundException;
import com.solvd.hospital.model.Exception.PersonNotInDatabaseException;

import java.util.List;

public interface IAskFor {

    public abstract void askForItem(Employee employee) throws ItemNotFoundException, ItemNotAvailableException;

    public abstract List<String> askForMedicalHistory(Employee employee, Patient patient) throws PersonNotInDatabaseException;


}
