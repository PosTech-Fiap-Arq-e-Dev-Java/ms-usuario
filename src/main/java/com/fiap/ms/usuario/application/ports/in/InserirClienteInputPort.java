package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public interface InserirClienteInputPort {

    void inserir(UsuarioDomain usuarioDomain);
}
