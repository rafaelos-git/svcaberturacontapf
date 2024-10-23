package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.client.EnviarCpfParaValidacaoClient;
import com.santander.svcaberturaconta.adapters.out.exceptions.ApiException;
import com.santander.svcaberturaconta.application.ports.out.EnviarCpfParaValidacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@Component
public class EnviarCpfParaValidacaoAdapter implements EnviarCpfParaValidacaoOutputPort {
    @Autowired
    private EnviarCpfParaValidacaoClient enviarCpfParaValidacaoClient;

    @Override
    public boolean enviar(String cpf) {
        try {
            var validaCpfResponse = enviarCpfParaValidacaoClient.enviar(cpf);
            return validaCpfResponse.getIsValid();
        } catch (RestClientException e) {
            throw new ApiException("Erro ao consultar a API de CPF: " + cpf, e);
        } catch (Exception e) {
            return false;
        }
    }
}
