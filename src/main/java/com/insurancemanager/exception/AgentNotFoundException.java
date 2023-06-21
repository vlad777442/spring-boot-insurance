package com.insurancemanager.exception;

public class AgentNotFoundException extends RuntimeException {
    public AgentNotFoundException() {
        super();
    }

    public AgentNotFoundException(String message) {
        super(message);
    }
}
