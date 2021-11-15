package com.solvd.hospital.model.Exception;

public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}
