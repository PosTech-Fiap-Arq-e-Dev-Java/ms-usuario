package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.DeletarUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarUsuarioOutputPort;

public class DeletarUsuarioUseCase implements DeletarUsuarioInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private final DeletarUsuarioOutputPort deletarUsuarioOutputPort;

    public DeletarUsuarioUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                 DeletarUsuarioOutputPort deletarUsuarioOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.deletarUsuarioOutputPort = deletarUsuarioOutputPort;
    }

    @Override
    public void deletarPorLogin(String login) {
        var usuario = buscarUsuarioOutputPort.buscarPorLogin(login);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException(login);
        }
        deletarUsuarioOutputPort.deletarPorId(usuario.getId());
    }
}

