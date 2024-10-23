package com.santander.svcaberturaconta.adapters.out.repository;

import com.santander.svcaberturaconta.adapters.out.repository.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntity, String> {
}
