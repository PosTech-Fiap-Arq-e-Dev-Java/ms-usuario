package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;

public interface AtualizarRestauranteInputPort {

    void atualizar(String usuario, RestauranteDomain restauranteDomain);
}
