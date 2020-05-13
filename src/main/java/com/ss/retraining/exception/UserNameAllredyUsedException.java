package com.ss.retraining.exception;

public class UserNameAllredyUsedException extends ServiceException {
    public UserNameAllredyUsedException() {
    }

    public UserNameAllredyUsedException(String message) {
        super(message);
    }

}
