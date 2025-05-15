package com.fiap.ms.usuario.application.core.domain.exception;

import lombok.Getter;

@Getter
public class CampoObrigatorioException extends RuntimeException {

    private final String campo;

    public CampoObrigatorioException(String campo) {
        super(campo);
        this.campo = campo;
    }

}
