package com.fiap.ms.usuario.application.exception;

import lombok.Getter;

@Getter
public class CampoObrigatorioException extends RuntimeException {

    private final String campo;

    public CampoObrigatorioException(String campo) {
        super(campo);
        this.campo = campo;
    }

}
