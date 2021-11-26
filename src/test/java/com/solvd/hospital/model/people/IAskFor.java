package com.solvd.hospital.model.people;

import com.solvd.hospital.model.exception.ItemNotAvailableException;
import com.solvd.hospital.model.exception.ItemNotFoundException;
import com.solvd.hospital.model.exception.PersonNotInDatabaseException;

import java.util.List;

public interface IAskFor {

    void askForItem(Employee employee) throws ItemNotFoundException, ItemNotAvailableException;

    List<String> askForMedicalHistory(Employee employee, Patient patient) throws PersonNotInDatabaseException;


}
