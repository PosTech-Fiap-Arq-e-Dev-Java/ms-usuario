package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.AtualizarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.AtualizarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;

public class AtualizarRestauranteUseCase implements AtualizarRestauranteInputPort {

    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private final AtualizarRestauranteOutputPort atualizarRestauranteOutputPort;

    public AtualizarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                       AtualizarRestauranteOutputPort atualizarRestauranteOutputPort) {
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
        this.atualizarRestauranteOutputPort = atualizarRestauranteOutputPort;
    }

    @Override
    public void atualizar(String usuario, UsuarioDomain usuarioDomain) {
        var domain = buscarRestauranteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        domain.setEndereco(usuarioDomain.getEndereco());
        domain.setEmail(usuarioDomain.getEmail());
        domain.setNome(usuarioDomain.getNome());
        domain.setTelefone(usuarioDomain.getTelefone());

        atualizarRestauranteOutputPort.atualizar(domain);
    }
}
