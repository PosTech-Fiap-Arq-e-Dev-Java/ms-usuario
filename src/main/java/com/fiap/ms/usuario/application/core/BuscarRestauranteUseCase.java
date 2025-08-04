package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.BuscarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;

public class BuscarRestauranteUseCase implements BuscarRestauranteInputPort {

    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;

    public BuscarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort) {
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
    }

    @Override
    public RestauranteDomain buscar(String usuario) {
        return buscarRestauranteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));
    }
}
