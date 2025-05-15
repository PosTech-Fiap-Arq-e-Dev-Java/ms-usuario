package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public interface InserirRestauranteOutputPort {

    void inserir(UsuarioDomain usuarioDomain);
}
