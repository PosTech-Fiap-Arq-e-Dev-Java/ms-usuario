package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AtualizarRestauranteAdapterTest {

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private AtualizarRestauranteAdapter atualizarRestauranteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveAtualizarComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        atualizarRestauranteAdapter.atualizar(usuarioDomain);

        verify(repository, times(1)).save(restauranteEntity);
    }

    @Test
    void devePropagarExcecaoDoRepository() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        doThrow(new RuntimeException("Erro ao salvar")).when(repository).save(restauranteEntity);

        Assert.assertThrows(RuntimeException.class, () -> {
            atualizarRestauranteAdapter.atualizar(usuarioDomain);
        });

        verify(repository).save(restauranteEntity);
    }
}
