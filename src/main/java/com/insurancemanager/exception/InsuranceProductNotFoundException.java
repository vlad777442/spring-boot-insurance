package com.insurancemanager.exception;

public class InsuranceProductNotFoundException extends RuntimeException {
    public InsuranceProductNotFoundException() {
        super();
    }

    public InsuranceProductNotFoundException(String message) {
        super(message);
    }
}
