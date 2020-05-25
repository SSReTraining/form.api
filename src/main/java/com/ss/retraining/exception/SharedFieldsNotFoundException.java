package com.ss.retraining.exception;

public class SharedFieldsNotFoundException extends DatabaseItemNotFoundException {
    public SharedFieldsNotFoundException() {
    }

    public SharedFieldsNotFoundException(String message) {
        super(message);
    }

}
