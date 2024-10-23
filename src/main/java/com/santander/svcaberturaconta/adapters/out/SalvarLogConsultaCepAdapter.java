package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.repository.LogRepository;
import com.santander.svcaberturaconta.adapters.out.repository.mapper.LogEntityMapper;
import com.santander.svcaberturaconta.application.core.domain.Log;
import com.santander.svcaberturaconta.application.ports.out.SalvarLogConsultaCepOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarLogConsultaCepAdapter implements SalvarLogConsultaCepOutputPort {
    @Autowired
    private LogEntityMapper logEntityMapper;

    @Autowired
    private LogRepository logRepository;

    @Override
    public void salvar(Log log) {
        var logEntity = logEntityMapper.toLogEntity(log);
        logRepository.save(logEntity);
    }
}
