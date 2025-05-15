package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.AtualizarClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;

public class AtualizarClienteUseCase implements AtualizarClienteInputPort {

    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final AtualizarClienteOutputPort atualizarClienteOutputPort;

    public AtualizarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                   AtualizarClienteOutputPort atualizarClienteOutputPort) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.atualizarClienteOutputPort = atualizarClienteOutputPort;
    }

    @Override
    public void atualizar(String usuario, UsuarioDomain usuarioDomain) {
        UsuarioDomain domain = buscarClienteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        domain.setEndereco(usuarioDomain.getEndereco());
        domain.setEmail(usuarioDomain.getEmail());
        domain.setNome(usuarioDomain.getNome());
        domain.setTelefone(usuarioDomain.getTelefone());

        atualizarClienteOutputPort.atualizar(domain);
    }
}
