package com.santander.svcaberturaconta.application.core.usecase;

import com.santander.svcaberturaconta.application.core.domain.Conta;
import com.santander.svcaberturaconta.application.core.domain.Endereco;
import com.santander.svcaberturaconta.application.core.domain.Log;
import com.santander.svcaberturaconta.application.exceptions.CepInvalidoException;
import com.santander.svcaberturaconta.application.exceptions.ContaJaExisteException;
import com.santander.svcaberturaconta.application.exceptions.CpfInvalidoException;
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
    ) {
        this.consultarContaPorCpfOutputPort = consultarContaPorCpfOutputPort;
        this.enviarCpfParaValidacaoOutputPort = enviarCpfParaValidacaoOutputPort;
        this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
        this.salvarLogConsultaCepOutputPort = salvarLogConsultaCepOutputPort;
        this.cadastrarContaOutputPort = cadastrarContaOutputPort;
        this.enviarDadosContaParaKafkaOutputPort = enviarDadosContaParaKafkaOutputPort;
    }

    @Override
    public void cadastrar(Conta conta, String cep) {
        if (contaJaExiste(conta.getCpfTitular())) {
            throw new ContaJaExisteException("Conta já existe para o CPF: " + conta.getCpfTitular());
        }

        if (!validarCpf(conta)) {
            throw new CpfInvalidoException("CPF inválido: " + conta.getCpfTitular());
        }

        consultarEnderecoPorCepOutputPort.consultar(cep)
                .ifPresentOrElse(
                        endereco -> processarCadastro(conta, endereco),
                        this::logFalhaNoEndereco
                );
    }

    private boolean contaJaExiste(String cpf) {
        return consultarContaPorCpfOutputPort.consultar(cpf);
    }

    private boolean validarCpf(Conta conta) {
        boolean isCpfValido = enviarCpfParaValidacaoOutputPort.enviar(conta.getCpfTitular());
        conta.setIsCpfValido(isCpfValido);
        return isCpfValido;
    }

    private void processarCadastro(Conta conta, Endereco endereco) {
        System.out.println(endereco.getCidade());
        conta.setEndereco(endereco);
        salvarLogConsultaCepOutputPort.salvar(new Log(endereco));

        Integer numeroConta = cadastrarContaOutputPort.cadastrar(conta);
        conta.setNumeroConta(numeroConta);

        enviarDadosContaParaKafkaOutputPort.enviar(conta);
    }

    private void logFalhaNoEndereco() {
        salvarLogConsultaCepOutputPort.salvar(new Log(null));
        throw new CepInvalidoException("CEP Invalido");
    }
}