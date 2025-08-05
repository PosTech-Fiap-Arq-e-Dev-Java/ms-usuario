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

class DeletarRestauranteAdapterTest {

    private RestauranteRepository restauranteRepository;
    private RestauranteEntityMapper restauranteEntityMapper;
    private DeletarRestauranteAdapter deletarRestauranteAdapter;

    @BeforeEach
    void setUp() {
        restauranteRepository = mock(RestauranteRepository.class);
        restauranteEntityMapper = mock(RestauranteEntityMapper.class);
        deletarRestauranteAdapter = new DeletarRestauranteAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Test
    void deveChamarDeleteComEntidadeMapeada() {
        // Arrange
        RestauranteDomain domain = new RestauranteDomain();
        domain.setId(1L);
        domain.setNome("Restaurante Teste");
        domain.setUsuario("restaurante123");

        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(1L);
        entity.setNome("Restaurante Teste");
        entity.setUsuario("restaurante123");

        when(restauranteEntityMapper.toRestauranteEntity(domain)).thenReturn(entity);

        deletarRestauranteAdapter.deletar(domain);

        ArgumentCaptor<RestauranteEntity> captor = ArgumentCaptor.forClass(RestauranteEntity.class);
        verify(restauranteRepository, times(1)).delete(captor.capture());

        RestauranteEntity capturado = captor.getValue();
        assertEquals(entity.getId(), capturado.getId());
        assertEquals(entity.getUsuario(), capturado.getUsuario());
        assertEquals(entity.getNome(), capturado.getNome());
    }
}

