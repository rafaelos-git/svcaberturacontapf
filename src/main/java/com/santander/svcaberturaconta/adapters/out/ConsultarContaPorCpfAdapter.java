package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.repository.ContaRepository;
import com.santander.svcaberturaconta.application.ports.out.ConsultarContaPorCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultarContaPorCpfAdapter implements ConsultarContaPorCpfOutputPort {
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public boolean consultar(String cpf) {
        return contaRepository.existsByCpfTitular(cpf);
    }
}
