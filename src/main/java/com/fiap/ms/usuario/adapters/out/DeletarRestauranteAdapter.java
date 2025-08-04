package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.ports.out.DeletarRestauranteOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarRestauranteAdapter implements DeletarRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    @Override
    @Transactional
    public void deletar(RestauranteDomain usuarioDomain) {
        var entity = restauranteEntityMapper.toRestauranteEntity(usuarioDomain);
        restauranteRepository.delete(entity);
    }
}

