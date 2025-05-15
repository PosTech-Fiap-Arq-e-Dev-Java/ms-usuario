package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public interface AtualizarRestauranteOutputPort {

    void atualizar(UsuarioDomain usuarioDomain);
}
