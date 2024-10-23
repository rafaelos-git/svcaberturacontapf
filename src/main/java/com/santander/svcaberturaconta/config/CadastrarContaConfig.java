package com.santander.svcaberturaconta.config;

import com.santander.svcaberturaconta.adapters.out.*;
import com.santander.svcaberturaconta.application.core.usecase.CadastrarContaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarContaConfig {
    @Bean
    public CadastrarContaUseCase cadastrarContaUseCase(
            ConsultarContaPorCpfAdapter consultarContaPorCpfAdapter,
            EnviarCpfParaValidacaoAdapter enviarCpfParaValidacaoAdapter,
            ConsultarEnderecoPorCepAdapter consultarEnderecoPorCepAdapter,
            SalvarLogConsultaCepAdapter salvarLogConsultaCepAdapter,
            CadastrarContaAdapter cadastrarContaAdapter,
            EnviarDadosContaParaKafkaAdapter enviarDadosContaParaKafkaAdapter
    ) {
        return new CadastrarContaUseCase(
                consultarContaPorCpfAdapter,
                enviarCpfParaValidacaoAdapter,
                consultarEnderecoPorCepAdapter,
                salvarLogConsultaCepAdapter,
                cadastrarContaAdapter,
                enviarDadosContaParaKafkaAdapter
        );
    }
}
