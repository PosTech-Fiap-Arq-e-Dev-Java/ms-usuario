package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.InserirRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;

public class InserirRestauranteUseCase implements InserirRestauranteInputPort {

    private final InserirRestauranteOutputPort inserirRestauranteOutputPort;
    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private final RestauranteValidatorHandler usuarioValidatorHandler;

    public InserirRestauranteUseCase(InserirRestauranteOutputPort inserirRestauranteOutputPort,
                                     BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                     RestauranteValidatorHandler usuarioValidatorHandler){
        this.inserirRestauranteOutputPort = inserirRestauranteOutputPort;
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
        this.usuarioValidatorHandler = usuarioValidatorHandler;
    }

    @Override
    public void inserir(RestauranteDomain usuarioDomain) {
        usuarioValidatorHandler.validarCamposObrigatoriosRestaurante(usuarioDomain);

        buscarRestauranteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                        usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail())
                .ifPresent(cliente -> {
                    throw new UsuarioJaExistenteException();
                });

        inserirRestauranteOutputPort.inserir(usuarioDomain);
    }
}
