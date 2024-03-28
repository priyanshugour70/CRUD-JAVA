package com.pg.exception;

public enum CustomExceptionType {
    STUDENT_NOT_FOUND("Student not found."),
    INVALID_STUDENT_DATA("Invalid student data."),
    // we will add more exception

    // default
    DEFAULT("An error occurred.");

    // Message associated with the exception type
    private final String message;

    // Constructor to initialize the exception type with a message
    CustomExceptionType(String message) {
        this.message = message;
    }

    // Getter method to retrieve the message associated with the exception type
    public String getMessage() {
        return message;
    }
}
