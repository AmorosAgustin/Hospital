package com.solvd.hospital.model.exception;

public class QueueIsEmptyException extends RuntimeException {
    public QueueIsEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
