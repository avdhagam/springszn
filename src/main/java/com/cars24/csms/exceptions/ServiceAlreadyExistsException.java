package com.cars24.csms.exceptions;

public class ServiceAlreadyExistsException extends RuntimeException {
    public ServiceAlreadyExistsException(String message) {
        super(message); // Pass the custom message to the superclass (RuntimeException)
    }
}