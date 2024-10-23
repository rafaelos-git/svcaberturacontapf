package com.santander.svcaberturaconta.application.ports.out;

import com.santander.svcaberturaconta.application.core.domain.Conta;

public interface EnviarDadosContaParaKafkaOutputPort {
    void enviar(Conta conta);
}
