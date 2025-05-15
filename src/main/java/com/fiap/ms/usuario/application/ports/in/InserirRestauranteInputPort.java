package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public interface InserirRestauranteInputPort {

    void inserir(UsuarioDomain usuarioDomain);
}
