package com.santander.svcaberturaconta.application.exceptions;

public class CepInvalidoException extends RuntimeException {
    public CepInvalidoException(String message) {
        super(message);
    }
}
