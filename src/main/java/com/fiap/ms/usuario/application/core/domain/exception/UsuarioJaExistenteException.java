package com.fiap.ms.usuario.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioJaExistenteException extends ResponseStatusException {

    public UsuarioJaExistenteException() {
        super(HttpStatus.CONFLICT, "Usuário, telefone ou e-mail já existem.");
    }
}
