package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.exceptions.FalhaSalvarLogException;
import com.santander.svcaberturaconta.adapters.out.repository.LogRepository;
import com.santander.svcaberturaconta.adapters.out.repository.mapper.LogEntityMapper;
import com.santander.svcaberturaconta.application.core.domain.Log;
import com.santander.svcaberturaconta.application.ports.out.SalvarLogConsultaCepOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class SalvarLogConsultaCepAdapter implements SalvarLogConsultaCepOutputPort {
    @Autowired
    private LogEntityMapper logEntityMapper;

    @Autowired
    private LogRepository logRepository;

    @Override
    public void salvar(Log log) {
        try {
            var logEntity = logEntityMapper.toLogEntity(log);
            logRepository.save(logEntity);
        } catch (DataIntegrityViolationException e) {
            throw new FalhaSalvarLogException("Erro ao salvar log: violação de integridade de dados", e);
        } catch (DataAccessException e) {
            throw new FalhaSalvarLogException("Erro ao salvar log no banco de dados", e);
        }
    }
}
