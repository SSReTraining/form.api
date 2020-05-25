package com.ss.retraining.exception;

public class FormFieldsNotFoundException extends DatabaseItemNotFoundException {
    public FormFieldsNotFoundException() {
    }

    public FormFieldsNotFoundException(String message) {
        super(message);
    }

}
