package com.santander.svcaberturaconta.application.core.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco() {

    }

    public Endereco(String rua, String bairro, String cidade, String estado, String pais) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
