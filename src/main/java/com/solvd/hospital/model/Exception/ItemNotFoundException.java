package com.solvd.hospital.model.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
