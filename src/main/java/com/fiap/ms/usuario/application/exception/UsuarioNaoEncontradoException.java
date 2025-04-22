package com.fiap.ms.usuario.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String login) {
        super("Usuário com login '" +login + "' não encontrado.");
    }
}
