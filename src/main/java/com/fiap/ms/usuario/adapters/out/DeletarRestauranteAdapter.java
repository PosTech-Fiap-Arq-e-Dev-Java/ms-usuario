package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.DeletarRestauranteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarRestauranteAdapter implements DeletarRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;

    @Override
    public void deletar(UsuarioDomain usuarioDomain) {
        var entity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);
        restauranteRepository.delete(entity);
    }
}
