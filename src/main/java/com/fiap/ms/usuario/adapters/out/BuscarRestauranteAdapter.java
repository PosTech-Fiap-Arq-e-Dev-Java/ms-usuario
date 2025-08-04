package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarRestauranteAdapter implements BuscarRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    @Override
    public Optional<RestauranteDomain> buscar(String usuario) {
        return restauranteRepository.findByUsuario(usuario)
                .map(restauranteEntityMapper::toRestauranteDomain);
    }

    @Override
    public Optional<RestauranteDomain> buscarPorUsuarioOuTelefoneOuEmail(String usuario, String telefone, String email) {
        var restauranteEntity = restauranteRepository.findByUsuarioOrTelefoneOrEmail(usuario, telefone, email);
        return restauranteEntity.map(restauranteEntityMapper::toRestauranteDomain);
    }
}

