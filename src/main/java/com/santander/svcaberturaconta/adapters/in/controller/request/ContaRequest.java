package com.santander.svcaberturaconta.adapters.in.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContaRequest {
    @NotBlank
    private String cpfTitular;
    @NotBlank
    private String cep;
}
