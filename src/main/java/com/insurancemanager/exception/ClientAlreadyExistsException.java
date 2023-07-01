package com.insurancemanager.exception;

public class ClientAlreadyExistsException extends RuntimeException {
    public ClientAlreadyExistsException() {
        super();
    }

    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
