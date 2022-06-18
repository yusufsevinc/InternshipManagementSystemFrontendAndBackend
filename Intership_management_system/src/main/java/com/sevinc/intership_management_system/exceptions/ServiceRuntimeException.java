package com.sevinc.intership_management_system.exceptions;

import lombok.Getter;

@Getter
public class ServiceRuntimeException extends RuntimeException {


    private final String description;

    public ServiceRuntimeException(String message) {
        super(message);
        this.description = null;
    }
}