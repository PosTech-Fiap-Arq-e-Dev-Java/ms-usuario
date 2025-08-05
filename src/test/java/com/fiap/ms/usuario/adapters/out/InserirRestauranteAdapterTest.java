package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InserirRestauranteAdapterTest {

    private RestauranteRepository restauranteRepository;
    private RestauranteEntityMapper restauranteEntityMapper;
    private InserirRestauranteAdapter inserirRestauranteAdapter;

    @BeforeEach
    void setUp() {
        restauranteRepository = mock(RestauranteRepository.class);
        restauranteEntityMapper = mock(RestauranteEntityMapper.class);
        inserirRestauranteAdapter = new InserirRestauranteAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Test
    void deveChamarSaveComEntidadeMapeadaCorretamente() {
        RestauranteDomain domain = new RestauranteDomain();
        domain.setId(10L);
        domain.setNome("Restaurante Exemplo");
        domain.setUsuario("rest123");

        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(10L);
        entity.setNome("Restaurante Exemplo");
        entity.setUsuario("rest123");

        when(restauranteEntityMapper.toRestauranteEntity(domain)).thenReturn(entity);

        inserirRestauranteAdapter.inserir(domain);

        ArgumentCaptor<RestauranteEntity> captor = ArgumentCaptor.forClass(RestauranteEntity.class);
        verify(restauranteRepository, times(1)).save(captor.capture());

        RestauranteEntity capturado = captor.getValue();
        assertEquals(entity.getId(), capturado.getId());
        assertEquals(entity.getNome(), capturado.getNome());
        assertEquals(entity.getUsuario(), capturado.getUsuario());
    }
}