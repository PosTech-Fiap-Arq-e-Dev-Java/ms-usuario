package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InserirRestauranteAdapter implements InserirRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;

    @Override
    @Transactional
    public void inserir(UsuarioDomain usuarioDomain) {
        var restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);
        restauranteRepository.save(restauranteEntity);
    }
}
