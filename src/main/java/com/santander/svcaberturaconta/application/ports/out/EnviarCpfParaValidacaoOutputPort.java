package com.santander.svcaberturaconta.application.ports.out;

public interface EnviarCpfParaValidacaoOutputPort {
    boolean enviar(String cpf);
}
