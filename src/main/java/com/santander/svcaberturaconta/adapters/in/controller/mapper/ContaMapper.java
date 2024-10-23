package com.santander.svcaberturaconta.adapters.in.controller.mapper;

import com.santander.svcaberturaconta.adapters.in.controller.request.ContaRequest;
import com.santander.svcaberturaconta.application.core.domain.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContaMapper {
    @Mapping(target = "numeroConta", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "isCpfValido", ignore = true)
    Conta toConta(ContaRequest contaRequest);
}
