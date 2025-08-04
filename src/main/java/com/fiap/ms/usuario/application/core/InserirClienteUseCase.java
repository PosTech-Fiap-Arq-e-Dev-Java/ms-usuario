package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;
    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final ClienteValidatorHandler usuarioValidatorHandler;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort,
                                 BuscarClienteOutputPort buscarClienteOutputPort,
                                 ClienteValidatorHandler usuarioValidatorHandler){
        this.inserirClienteOutputPort = inserirClienteOutputPort;
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.usuarioValidatorHandler = usuarioValidatorHandler;
    }

    @Override
    public void inserir(ClienteDomain clienteDomain) {
        usuarioValidatorHandler.validarCamposObrigatoriosCliente(clienteDomain);

        buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                clienteDomain.getUsuario(), clienteDomain.getTelefone(), clienteDomain.getEmail())
                .ifPresent(cliente -> {
                    throw new UsuarioJaExistenteException();
                });


        inserirClienteOutputPort.inserir(clienteDomain);
    }
}
