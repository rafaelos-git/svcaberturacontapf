package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.repository.ContaRepository;
import com.santander.svcaberturaconta.adapters.out.repository.mapper.ContaEntityMapper;
import com.santander.svcaberturaconta.application.core.domain.Conta;
import com.santander.svcaberturaconta.application.ports.out.CadastrarContaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastrarContaAdapter implements CadastrarContaOutputPort {
    @Autowired
    private ContaEntityMapper contaEntityMapper;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Integer cadastrar(Conta conta) {
        var contaEntity = contaEntityMapper.toContaEntity(conta);
        contaRepository.save(contaEntity);
        return contaEntity.getNumeroConta();
    }
}
