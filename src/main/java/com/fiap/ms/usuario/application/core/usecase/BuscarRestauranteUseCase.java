package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.BuscarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;

public class BuscarRestauranteUseCase implements BuscarRestauranteInputPort {

    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;

    public BuscarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort) {
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
    }

    @Override
    public UsuarioDomain buscar(String usuario) {
        return buscarRestauranteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));
    }
}
