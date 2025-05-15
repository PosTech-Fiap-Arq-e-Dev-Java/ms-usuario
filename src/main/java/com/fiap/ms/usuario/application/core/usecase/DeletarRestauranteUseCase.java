package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.DeletarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarRestauranteOutputPort;

public class DeletarRestauranteUseCase implements DeletarRestauranteInputPort {

    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private final DeletarRestauranteOutputPort deletarRestauranteOutputPort;

    public DeletarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                     DeletarRestauranteOutputPort deletarRestauranteOutputPort) {
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
        this.deletarRestauranteOutputPort = deletarRestauranteOutputPort;
    }

    @Override
    public void deletar(String usuario) {
        var usuarioDomain = buscarRestauranteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        deletarRestauranteOutputPort.deletar(usuarioDomain);
    }
}
