package ru.urfu.springskblab.exception;

public class CustomBadGatewayException extends RuntimeException {
    public CustomBadGatewayException(String message) {
        super(message);
    }
}

