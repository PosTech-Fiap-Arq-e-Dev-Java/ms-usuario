package com.fiap.ms.usuario.application.core.handler;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;

public interface RestauranteValidatorHandler {

    void validarCamposObrigatoriosRestaurante(RestauranteDomain restauranteDomain);
    void validarCamposObrigatoriosAtualizarRestaurante(RestauranteDomain restauranteDomain);
    void validarDadosIguaisRestaurante(RestauranteDomain novo, RestauranteDomain existente);
}

