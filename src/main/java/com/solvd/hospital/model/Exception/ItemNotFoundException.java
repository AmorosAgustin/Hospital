package com.solvd.hospital.model.Exception;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
