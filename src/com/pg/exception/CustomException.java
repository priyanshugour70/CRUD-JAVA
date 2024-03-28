package com.pg.exception;

public class CustomException extends Exception {
    private final CustomExceptionType exceptionType;

    // Constructor to initialize the custom exception with a specific type
    public CustomException(CustomExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    // Getter method to retrieve the exception type
    public CustomExceptionType getExceptionType() {
        return exceptionType;
    }
}
