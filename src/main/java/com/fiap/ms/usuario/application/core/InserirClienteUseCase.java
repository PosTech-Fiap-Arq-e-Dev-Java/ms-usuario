package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;
    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final UsuarioValidatorHandler usuarioValidatorHandler;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort,
                                 BuscarClienteOutputPort buscarClienteOutputPort,
                                 UsuarioValidatorHandler usuarioValidatorHandler){
        this.inserirClienteOutputPort = inserirClienteOutputPort;
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.usuarioValidatorHandler = usuarioValidatorHandler;
    }

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        usuarioValidatorHandler.validarCamposObrigatoriosUsuario(usuarioDomain);

        buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail())
                .ifPresent(cliente -> {
                    throw new UsuarioJaExistenteException();
                });


        inserirClienteOutputPort.inserir(usuarioDomain);
    }
}
