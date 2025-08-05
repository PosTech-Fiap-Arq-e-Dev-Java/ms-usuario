package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InserirRestauranteAdapterTest {
/*
    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private InserirRestauranteAdapter inserirRestauranteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveInserirLoginComSucesso() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        inserirRestauranteAdapter.inserir(usuarioDomain);

        verify(repository, times(1)).save(restauranteEntity);
    }

    @Test
    void devePropagarExcecaoDoRepository() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        doThrow(new RuntimeException("Erro ao salvar")).when(repository).save(restauranteEntity);

        assertThrows(RuntimeException.class, () -> {
            inserirRestauranteAdapter.inserir(usuarioDomain);
        });

        verify(repository).save(restauranteEntity);
    }

 */
}
