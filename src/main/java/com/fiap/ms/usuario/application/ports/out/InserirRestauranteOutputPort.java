package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;

public interface InserirRestauranteOutputPort {

    void inserir(RestauranteDomain restauranteDomain);
}
