package com.santander.svcaberturaconta.adapters.out.repository.mapper;

import com.santander.svcaberturaconta.adapters.out.repository.entity.ContaEntity;
import com.santander.svcaberturaconta.application.core.domain.Conta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContaEntityMapper {
    ContaEntity toContaEntity(Conta conta);
}
