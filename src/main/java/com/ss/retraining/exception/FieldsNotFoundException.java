package com.ss.retraining.exception;

public class FieldsNotFoundException extends DatabaseItemNotFoundException {
    public FieldsNotFoundException() {
    }

    public FieldsNotFoundException(String message) {
        super(message);
    }

}
