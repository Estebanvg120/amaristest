package com.amaristest.amaristest.infrastructure.exception;

public class ErrorFeignException extends RuntimeException {
    public ErrorFeignException(String message) {
        super(message);
    }
}
