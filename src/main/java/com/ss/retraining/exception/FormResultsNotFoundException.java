package com.ss.retraining.exception;

public class FormResultsNotFoundException extends DatabaseItemNotFoundException {
    public FormResultsNotFoundException() {
    }

    public FormResultsNotFoundException(String message) {
        super(message);
    }

}
