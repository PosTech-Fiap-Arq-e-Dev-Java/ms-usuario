package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.InserirRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;

public class InserirRestauranteUseCase implements InserirRestauranteInputPort {

    private final InserirRestauranteOutputPort inserirRestauranteOutputPort;
    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private final UsuarioValidatorHandler usuarioValidatorHandler;

    public InserirRestauranteUseCase(InserirRestauranteOutputPort inserirRestauranteOutputPort,
                                     BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                     UsuarioValidatorHandler usuarioValidatorHandler){
        this.inserirRestauranteOutputPort = inserirRestauranteOutputPort;
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
        this.usuarioValidatorHandler = usuarioValidatorHandler;
    }

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        usuarioValidatorHandler.validarCamposObrigatoriosUsuario(usuarioDomain);

        buscarRestauranteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                        usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail())
                .ifPresent(cliente -> {
                    throw new UsuarioJaExistenteException();
                });

        inserirRestauranteOutputPort.inserir(usuarioDomain);
    }
}
