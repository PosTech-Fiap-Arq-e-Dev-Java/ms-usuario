package com.fiap.ms.usuario.application.core.handler;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public interface UsuarioValidatorHandler {

    void validarCamposObrigatoriosUsuario(UsuarioDomain usuarioDomain);
}
