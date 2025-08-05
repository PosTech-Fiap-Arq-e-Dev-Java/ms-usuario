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

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeletarRestauranteAdapterTest {
/*
    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private DeletarRestauranteAdapter deletarRestauranteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveDeletarComIdValido() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        when(repository.findByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(restauranteEntity));

        deletarRestauranteAdapter.deletar(usuarioDomain);

        verify(repository, times(1)).delete(restauranteEntity);
    }

    @Test
    void devePropagarExcecaoSeRepositoryFalhar() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        when(repository.findByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(restauranteEntity));

        doThrow(new RuntimeException("Erro ao deletar")).when(repository).delete(restauranteEntity);

        assertThrows(RuntimeException.class, () -> {
            deletarRestauranteAdapter.deletar(usuarioDomain);
        });

        verify(repository).delete(restauranteEntity);
    }

 */
}
