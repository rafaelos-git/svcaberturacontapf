package com.santander.svcaberturaconta.application.ports.out;

import com.santander.svcaberturaconta.application.core.domain.Conta;

public interface CadastrarContaOutputPort {
    Integer cadastrar(Conta conta);
}
