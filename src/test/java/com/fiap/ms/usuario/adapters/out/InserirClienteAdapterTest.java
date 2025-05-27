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

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InserirClienteAdapterTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private InserirClienteAdapter inserirClienteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveInserirLoginComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);

        inserirClienteAdapter.inserir(usuarioDomain);

        verify(repository, times(1)).save(clienteEntity);
    }

    @Test
    void devePropagarExcecaoDoRepository() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);

        doThrow(new RuntimeException("Erro ao salvar")).when(repository).save(clienteEntity);

        assertThrows(RuntimeException.class, () -> {
            inserirClienteAdapter.inserir(usuarioDomain);
        });

        verify(repository).save(clienteEntity);
    }
}
