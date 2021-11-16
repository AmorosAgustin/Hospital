package com.solvd.hospital.model.exception;

public class PersonAlreadyInDatabaseException extends RuntimeException {
    public PersonAlreadyInDatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
