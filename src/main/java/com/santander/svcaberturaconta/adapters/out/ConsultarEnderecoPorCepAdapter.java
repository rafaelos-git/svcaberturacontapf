package com.santander.svcaberturaconta.adapters.out;

import com.santander.svcaberturaconta.adapters.out.client.ConsultarEnderecoPorCepClient;
import com.santander.svcaberturaconta.adapters.out.client.mapper.EnderecoResponseMapper;
import com.santander.svcaberturaconta.adapters.out.exceptions.ApiException;
import com.santander.svcaberturaconta.application.core.domain.Endereco;
import com.santander.svcaberturaconta.application.ports.out.ConsultarEnderecoPorCepOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@Component
public class ConsultarEnderecoPorCepAdapter implements ConsultarEnderecoPorCepOutputPort {
    @Autowired
    private ConsultarEnderecoPorCepClient consultarEnderecoPorCepClient;

    @Autowired
    private EnderecoResponseMapper enderecoResponseMapper;

    @Override
    public Optional<Endereco> consultar(String cep) {
        try {
            var enderecoResponse = consultarEnderecoPorCepClient.consultar(cep);
            return Optional.ofNullable(enderecoResponseMapper.toEndereco(enderecoResponse));
        } catch (RestClientException e) {
            throw new ApiException("Erro ao consultar a API de CEP: " + cep, e);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
