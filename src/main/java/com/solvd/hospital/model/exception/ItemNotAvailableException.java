package com.solvd.hospital.model.exception;

public class ItemNotAvailableException extends RuntimeException {
    public ItemNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}
