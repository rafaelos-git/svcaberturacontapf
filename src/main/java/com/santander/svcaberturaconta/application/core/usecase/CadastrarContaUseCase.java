package com.santander.svcaberturaconta.application.core.usecase;

import com.santander.svcaberturaconta.application.core.domain.Conta;
import com.santander.svcaberturaconta.application.core.domain.Log;
import com.santander.svcaberturaconta.application.ports.in.CadastrarContaInputPort;
import com.santander.svcaberturaconta.application.ports.out.*;

public class CadastrarContaUseCase implements CadastrarContaInputPort {
    private final ConsultarContaPorCpfOutputPort consultarContaPorCpfOutputPort;
    private final EnviarCpfParaValidacaoOutputPort enviarCpfParaValidacaoOutputPort;
    private final ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort;
    private final SalvarLogConsultaCepOutputPort salvarLogConsultaCepOutputPort;
    private final CadastrarContaOutputPort cadastrarContaOutputPort;
    private final EnviarDadosContaParaKafkaOutputPort enviarDadosContaParaKafkaOutputPort;

    public CadastrarContaUseCase(
            ConsultarContaPorCpfOutputPort consultarContaPorCpfOutputPort,
            EnviarCpfParaValidacaoOutputPort enviarCpfParaValidacaoOutputPort,
            ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort,
            SalvarLogConsultaCepOutputPort salvarLogConsultaCepOutputPort,
            CadastrarContaOutputPort cadastrarContaOutputPort,
            EnviarDadosContaParaKafkaOutputPort enviarDadosContaParaKafkaOutputPort
    ){
        this.consultarContaPorCpfOutputPort = consultarContaPorCpfOutputPort;
        this.enviarCpfParaValidacaoOutputPort = enviarCpfParaValidacaoOutputPort;
        this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
        this.salvarLogConsultaCepOutputPort = salvarLogConsultaCepOutputPort;
        this.cadastrarContaOutputPort = cadastrarContaOutputPort;
        this.enviarDadosContaParaKafkaOutputPort = enviarDadosContaParaKafkaOutputPort;
    }

    @Override
    public void cadastrar(Conta conta, String cep) {
        if (consultarContaPorCpfOutputPort.consultar(conta.getCpfTitular())) {
            return;
        }
        conta.setIsCpfValido(enviarCpfParaValidacaoOutputPort.enviar(conta.getCpfTitular()));
        if (!conta.getIsCpfValido()) {
            return;
        }
        var endereco = consultarEnderecoPorCepOutputPort.consultar(cep);
        salvarLogConsultaCepOutputPort.salvar(new Log(endereco.orElse(null)));
        if (endereco.isEmpty()) {
            return;
        }
        conta.setEndereco(endereco.get());
        var numeroConta = cadastrarContaOutputPort.cadastrar(conta);
        conta.setNumeroConta(numeroConta);
        enviarDadosContaParaKafkaOutputPort.enviar(conta);
    }
}