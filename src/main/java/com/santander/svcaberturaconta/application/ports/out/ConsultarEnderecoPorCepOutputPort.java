package com.santander.svcaberturaconta.application.ports.out;

import com.santander.svcaberturaconta.application.core.domain.Endereco;

import java.util.Optional;

public interface ConsultarEnderecoPorCepOutputPort {
    Optional<Endereco> consultar(String cep);
}
