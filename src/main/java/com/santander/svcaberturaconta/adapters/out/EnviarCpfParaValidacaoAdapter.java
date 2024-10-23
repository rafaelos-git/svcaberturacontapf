package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.client.EnviarCpfParaValidacaoClient;
import com.santander.svcaberturaconta.application.ports.out.EnviarCpfParaValidacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnviarCpfParaValidacaoAdapter implements EnviarCpfParaValidacaoOutputPort {
    @Autowired
    private EnviarCpfParaValidacaoClient enviarCpfParaValidacaoClient;

    @Override
    public boolean enviar(String cpf) {
        var validaCpfResponse = enviarCpfParaValidacaoClient.enviar(cpf);
        return validaCpfResponse.getIsValid();
    }
}
