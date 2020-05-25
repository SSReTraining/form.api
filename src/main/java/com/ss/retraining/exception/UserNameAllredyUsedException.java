package com.ss.retraining.exception;

public class UserNameAllredyUsedException extends ConflictException {
    public UserNameAllredyUsedException() {
    }

    public UserNameAllredyUsedException(String message) {
        super(message);
    }

}
