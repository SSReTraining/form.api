package com.ss.retraining.exception;

public class InvalidDataException extends ServiceException {
    public InvalidDataException() {
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
