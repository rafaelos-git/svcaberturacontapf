package com.santander.svcaberturaconta.adapters.out.client.response;

import lombok.Data;

@Data
public class EnderecoResponse {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
}
