package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.in.DeletarClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarClienteOutputPort;

public class DeletarClienteUseCase implements DeletarClienteInputPort {

    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final DeletarClienteOutputPort deletarClienteOutputPort;

    public DeletarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                 DeletarClienteOutputPort deletarClienteOutputPort) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.deletarClienteOutputPort = deletarClienteOutputPort;
    }

    @Override
    public void deletar(String usuario) {
        var usuarioDomain = buscarClienteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        deletarClienteOutputPort.deletar(usuarioDomain);
    }
}
