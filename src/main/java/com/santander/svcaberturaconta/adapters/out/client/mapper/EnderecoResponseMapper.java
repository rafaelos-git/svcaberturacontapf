package com.santander.svcaberturaconta.adapters.out.client.mapper;

import com.santander.svcaberturaconta.adapters.out.client.response.EnderecoResponse;
import com.santander.svcaberturaconta.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {
    Endereco toEndereco(EnderecoResponse enderecoResponse);
}
