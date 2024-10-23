package com.santander.svcaberturaconta.application.core.domain;

import java.time.LocalDateTime;

public class Log {
    private String id;
    private LocalDateTime dataHora = LocalDateTime.now();
    private Endereco endereco;

    public Log() {
    }

    public Log(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
