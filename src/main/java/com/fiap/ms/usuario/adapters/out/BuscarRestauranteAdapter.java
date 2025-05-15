package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarRestauranteAdapter implements BuscarRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;

    @Override
    public Optional<UsuarioDomain> buscar(String usuario) {
        return restauranteRepository.findByUsuario(usuario)
                .map(RestauranteEntityMapper.INSTANCE::toUsuarioDomain);
    }
}
