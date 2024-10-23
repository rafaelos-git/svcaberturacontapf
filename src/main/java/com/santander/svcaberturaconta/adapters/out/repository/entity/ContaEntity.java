package com.santander.svcaberturaconta.adapters.out.repository.entity;

import com.santander.svcaberturaconta.application.core.domain.Endereco;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "conta_cliente")
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numeroConta;
    private String cpfTitular;
    @Embedded
    private Endereco endereco;
    private Boolean isCpfValido;
}
