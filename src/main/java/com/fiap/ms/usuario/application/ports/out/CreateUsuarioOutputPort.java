package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.Usuario;

public interface CreateUsuarioOutputPort {

    void salvar(Usuario usuario);
}
