package com.solvd.hospital.model.exception;

public class MachineryBrokenException extends RuntimeException {
    public MachineryBrokenException(String errorMessage) {
        super(errorMessage);
    }
}
