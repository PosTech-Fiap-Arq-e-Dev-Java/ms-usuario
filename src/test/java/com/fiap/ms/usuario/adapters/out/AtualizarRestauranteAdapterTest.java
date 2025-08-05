package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AtualizarRestauranteAdapterTest {

    private RestauranteRepository restauranteRepository;
    private RestauranteEntityMapper restauranteEntityMapper;
    private AtualizarRestauranteAdapter atualizarRestauranteAdapter;

    @BeforeEach
    void setup() {
        restauranteRepository = mock(RestauranteRepository.class);
        restauranteEntityMapper = mock(RestauranteEntityMapper.class);
        atualizarRestauranteAdapter = new AtualizarRestauranteAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Test
    void atualizar_deveConverterEDepoisSalvar() {
        RestauranteDomain domain = new RestauranteDomain();
        domain.setNome("Restaurante");

        RestauranteEntity entity = new RestauranteEntity();
        entity.setNome("Restaurante");

        when(restauranteEntityMapper.toRestauranteEntity(domain)).thenReturn(entity);
        when(restauranteRepository.save(entity)).thenReturn(entity);

        atualizarRestauranteAdapter.atualizar(domain);

        verify(restauranteEntityMapper).toRestauranteEntity(domain);

        ArgumentCaptor<RestauranteEntity> captor = ArgumentCaptor.forClass(RestauranteEntity.class);
        verify(restauranteRepository).save(captor.capture());

        RestauranteEntity savedEntity = captor.getValue();
        assertEquals(entity.getNome(), savedEntity.getNome());
    }
}

