package com.santander.svcaberturaconta.adapters.out.repository.entity;

import com.santander.svcaberturaconta.application.core.domain.Endereco;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "logs")
public class LogEntity {
    @Id
    private String id;
    private LocalDateTime dataHora;
    private Endereco endereco;
}
