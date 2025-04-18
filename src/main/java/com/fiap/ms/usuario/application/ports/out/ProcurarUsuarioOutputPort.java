package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.Usuario;

public interface ProcurarUsuarioOutputPort {

    Usuario buscar(String admin);
}
