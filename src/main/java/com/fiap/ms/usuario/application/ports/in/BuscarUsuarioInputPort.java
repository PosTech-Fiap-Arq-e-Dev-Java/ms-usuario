package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.Usuario;

public interface BuscarUsuarioInputPort {

    Usuario buscarPorLogin(String login);
}
