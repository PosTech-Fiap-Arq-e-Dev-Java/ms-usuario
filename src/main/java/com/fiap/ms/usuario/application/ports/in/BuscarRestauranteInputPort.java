package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;

public interface BuscarRestauranteInputPort {

    RestauranteDomain buscar(String usuario);
}
