package com.santander.svcaberturaconta.application.exceptions;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String message) {
        super(message);
    }
}
