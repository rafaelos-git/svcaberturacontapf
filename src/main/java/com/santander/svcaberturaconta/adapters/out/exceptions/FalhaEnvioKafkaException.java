package com.santander.svcaberturaconta.adapters.out.exceptions;

public class FalhaEnvioKafkaException extends RuntimeException {
    public FalhaEnvioKafkaException(String message, Throwable cause) {
        super(message, cause);
    }
}