package com.santander.svcaberturaconta.adapters.out.repository.mapper;

import com.santander.svcaberturaconta.adapters.out.repository.entity.LogEntity;
import com.santander.svcaberturaconta.application.core.domain.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogEntityMapper {
    LogEntity toLogEntity(Log log);
}
