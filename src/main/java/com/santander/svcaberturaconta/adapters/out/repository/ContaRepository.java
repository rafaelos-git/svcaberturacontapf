package com.santander.svcaberturaconta.adapters.out.repository;

import com.santander.svcaberturaconta.adapters.out.repository.entity.ContaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<ContaEntity, Integer> {
    boolean existsByCpfTitular(String cpfTitular);
}
