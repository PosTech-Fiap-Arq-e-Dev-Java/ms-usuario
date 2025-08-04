package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;

import java.util.Optional;

public interface BuscarRestauranteOutputPort {

    Optional<RestauranteDomain> buscar(String usuario);
    Optional<RestauranteDomain> buscarPorUsuarioOuTelefoneOuEmail(String usuario, String telefone, String email);
}
