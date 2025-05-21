package com.fiap.ms.usuario.application.core.handler.impl;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsuarioValidatorHandlerImpl implements UsuarioValidatorHandler {

    @Override
    public void validarCamposObrigatoriosUsuario(UsuarioDomain usuarioDomain) {
        if(Objects.isNull(usuarioDomain) || usuarioDomain.getEmail().isBlank()
        || usuarioDomain.getTelefone().isBlank() || usuarioDomain.getNome().isBlank() || usuarioDomain.getEndereco().isBlank()) {
            throw new CampoObrigatorioException();
        }
    }
}
