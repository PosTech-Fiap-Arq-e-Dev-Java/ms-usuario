package com.fiap.ms.usuario.application.core.domain;

public class Telefone {

    private Integer ddd;
    private Integer numero;

    public Telefone(){
    }

    public Telefone(Integer ddd, Integer numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
