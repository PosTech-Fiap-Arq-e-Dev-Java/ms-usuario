package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.BuscarClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;

public class BuscarClienteUseCase implements BuscarClienteInputPort {

    private final BuscarClienteOutputPort buscarClienteOutputPort;

    public BuscarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
    }

    @Override
    public UsuarioDomain buscar(String usuario) {
        return buscarClienteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));
    }
}
