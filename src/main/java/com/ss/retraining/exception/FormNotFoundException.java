package com.ss.retraining.exception;

public class FormNotFoundException extends DatabaseItemNotFoundException {
    public FormNotFoundException() {
    }

    public FormNotFoundException(String message) {
        super(message);
    }

}
