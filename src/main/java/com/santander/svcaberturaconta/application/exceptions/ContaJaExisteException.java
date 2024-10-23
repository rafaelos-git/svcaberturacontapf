package com.santander.svcaberturaconta.application.exceptions;

public class ContaJaExisteException extends RuntimeException {
    public ContaJaExisteException(String message) {
        super(message);
    }
}
