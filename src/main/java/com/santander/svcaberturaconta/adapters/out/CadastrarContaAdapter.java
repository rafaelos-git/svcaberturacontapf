package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.exceptions.FalhaCadastroContaException;
import com.santander.svcaberturaconta.adapters.out.repository.ContaRepository;
import com.santander.svcaberturaconta.adapters.out.repository.mapper.ContaEntityMapper;
import com.santander.svcaberturaconta.application.core.domain.Conta;
import com.santander.svcaberturaconta.application.ports.out.CadastrarContaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CadastrarContaAdapter implements CadastrarContaOutputPort {
    @Autowired
    private ContaEntityMapper contaEntityMapper;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Integer cadastrar(Conta conta) {
        try {
            var contaEntity = contaEntityMapper.toContaEntity(conta);
            contaRepository.save(contaEntity);
            return contaEntity.getNumeroConta();
        } catch (DataIntegrityViolationException e) {
            throw new FalhaCadastroContaException("Erro ao cadastrar conta para o CPF: " + conta.getCpfTitular(), e);
        }
    }
}
