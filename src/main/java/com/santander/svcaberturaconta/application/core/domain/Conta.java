package com.santander.svcaberturaconta.application.core.domain;

public class Conta {
    private Integer numeroConta;
    private String cpfTitular;
    private Endereco endereco;
    private Boolean isCpfValido;

    public Conta() {
        this.isCpfValido = false;
    }

    public Conta(Integer numeroConta, String cpfTitular, Endereco endereco, Boolean isCpfValido) {
        this.numeroConta = numeroConta;
        this.cpfTitular = cpfTitular;
        this.endereco = endereco;
        this.isCpfValido = isCpfValido;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getIsCpfValido() {
        return isCpfValido;
    }

    public void setIsCpfValido(Boolean cpfValido) {
        isCpfValido = cpfValido;
    }
}
