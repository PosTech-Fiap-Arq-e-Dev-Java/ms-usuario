package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.AtualizarClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;

public class AtualizarClienteUseCase implements AtualizarClienteInputPort {

    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final AtualizarClienteOutputPort atualizarClienteOutputPort;
    private final ClienteValidatorHandler clienteValidatorHandler;

    public AtualizarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                   AtualizarClienteOutputPort atualizarClienteOutputPort,
                                   ClienteValidatorHandler clienteValidatorHandler) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.atualizarClienteOutputPort = atualizarClienteOutputPort;
        this.clienteValidatorHandler = clienteValidatorHandler;
    }

    @Override
    public void atualizar(String usuario, ClienteDomain clienteDomain) {
        clienteValidatorHandler.validarCamposObrigatoriosAtualizarCliente(clienteDomain);

        ClienteDomain domain = buscarClienteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        clienteValidatorHandler.validarDadosIguaisCliente(clienteDomain, domain);

        domain.setEndereco(clienteDomain.getEndereco());
        domain.setEmail(clienteDomain.getEmail());
        domain.setNome(clienteDomain.getNome());
        domain.setTelefone(clienteDomain.getTelefone());
        atualizarClienteOutputPort.atualizar(domain);
    }
}


