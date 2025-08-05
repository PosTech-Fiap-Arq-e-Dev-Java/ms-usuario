package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.in.AtualizarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.AtualizarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;

public class AtualizarRestauranteUseCase implements AtualizarRestauranteInputPort {

    private final BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private final AtualizarRestauranteOutputPort atualizarRestauranteOutputPort;
    private final RestauranteValidatorHandler restauranteValidatorHandler;

    public AtualizarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                       AtualizarRestauranteOutputPort atualizarRestauranteOutputPort,
                                       RestauranteValidatorHandler restauranteValidatorHandler) {
        this.buscarRestauranteOutputPort = buscarRestauranteOutputPort;
        this.atualizarRestauranteOutputPort = atualizarRestauranteOutputPort;
        this.restauranteValidatorHandler = restauranteValidatorHandler;
    }

    @Override
    public void atualizar(String usuario, RestauranteDomain restauranteDomain) {
        restauranteValidatorHandler.validarCamposObrigatoriosAtualizarRestaurante(restauranteDomain);

        RestauranteDomain domain = buscarRestauranteOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        restauranteValidatorHandler.validarDadosIguaisRestaurante(restauranteDomain, domain);

        domain.setEndereco(restauranteDomain.getEndereco());
        domain.setEmail(restauranteDomain.getEmail());
        domain.setNome(restauranteDomain.getNome());
        domain.setTelefone(restauranteDomain.getTelefone());
        domain.setDonoRestaurante(restauranteDomain.getDonoRestaurante());
        domain.setHorarioFuncionamentoInicio(restauranteDomain.getHorarioFuncionamentoInicio());
        domain.setHorarioFuncionamentoFim(restauranteDomain.getHorarioFuncionamentoFim());
        domain.setTipoCozinha(restauranteDomain.getTipoCozinha());

        atualizarRestauranteOutputPort.atualizar(domain);
    }
}

