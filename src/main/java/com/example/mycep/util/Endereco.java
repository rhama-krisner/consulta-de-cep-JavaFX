package com.example.mycep.util;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String localidade;

    private int ddd;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String localidade, int ddd) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.ddd = ddd;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
}
