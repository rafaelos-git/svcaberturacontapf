package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.exceptions.FalhaConsultaContaException;
import com.santander.svcaberturaconta.adapters.out.repository.ContaRepository;
import com.santander.svcaberturaconta.application.ports.out.ConsultarContaPorCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ConsultarContaPorCpfAdapter implements ConsultarContaPorCpfOutputPort {
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public boolean consultar(String cpf) {
        try {
            return contaRepository.existsByCpfTitular(cpf);
        } catch (IllegalArgumentException e) {
            throw new FalhaConsultaContaException("Formato de CPF inválido: " + cpf, e);
        } catch (DataAccessException e) {
            throw new FalhaConsultaContaException("Erro ao consultar a conta no banco de dados para o CPF: " + cpf, e);
        }
    }
}
