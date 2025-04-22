package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;

import java.util.Optional;

public class BuscarUsuarioUseCase implements BuscarUsuarioInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public BuscarUsuarioUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        return Optional.ofNullable(buscarUsuarioOutputPort.buscarPorLogin(login))
                .orElseThrow(() -> new UsuarioNaoEncontradoException(login));

    }
}
