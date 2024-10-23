package com.santander.svcaberturaconta.application.ports.in;

import com.santander.svcaberturaconta.application.core.domain.Conta;

public interface CadastrarContaInputPort {
    void cadastrar(Conta conta, String cep);
}
