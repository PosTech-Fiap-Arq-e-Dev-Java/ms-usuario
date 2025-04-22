package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;

public class BuscarUsuarioUseCase implements BuscarUsuarioInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public BuscarUsuarioUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
    }

    @Override
    public Usuario buscar(String login) {
        return buscarUsuarioOutputPort.buscar(login);
    }
}
