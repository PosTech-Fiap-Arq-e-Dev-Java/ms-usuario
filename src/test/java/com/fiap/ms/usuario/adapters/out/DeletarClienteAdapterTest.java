package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.ClienteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
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

public class DeletarClienteAdapterTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private DeletarClienteAdapter deletarClienteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveDeletarComIdValido() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);

        when(repository.findByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(clienteEntity));

        deletarClienteAdapter.deletar(usuarioDomain);

        verify(repository, times(1)).delete(clienteEntity);
    }

    @Test
    void devePropagarExcecaoSeRepositoryFalhar() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);

        when(repository.findByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(clienteEntity));

        doThrow(new RuntimeException("Erro ao deletar")).when(repository).delete(clienteEntity);

        assertThrows(RuntimeException.class, () -> {
            deletarClienteAdapter.deletar(usuarioDomain);
        });

        verify(repository).delete(clienteEntity);
    }
}
