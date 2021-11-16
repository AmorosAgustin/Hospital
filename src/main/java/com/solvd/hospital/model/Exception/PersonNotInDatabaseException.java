package com.solvd.hospital.model.exception;

public class PersonNotInDatabaseException extends RuntimeException {
    public PersonNotInDatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
