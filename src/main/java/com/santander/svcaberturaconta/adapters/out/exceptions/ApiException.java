package com.santander.svcaberturaconta.adapters.out.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
