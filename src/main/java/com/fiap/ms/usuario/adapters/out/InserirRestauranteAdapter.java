package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirRestauranteAdapter implements InserirRestauranteOutputPort {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        var restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);
        restauranteRepository.save(restauranteEntity);
    }
}
