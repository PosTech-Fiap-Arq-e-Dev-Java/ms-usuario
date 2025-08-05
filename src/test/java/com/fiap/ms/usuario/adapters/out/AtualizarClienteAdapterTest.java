package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.ClienteEntity;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizarClienteAdapterTest {

    private ClienteRepository clienteRepository;
    private AtualizarClienteAdapter atualizarClienteAdapter;

    @BeforeEach
    void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        atualizarClienteAdapter = new AtualizarClienteAdapter(clienteRepository);
    }

    @Test
    void deveChamarSaveComEntidadeCorreta() {
        ClienteDomain clienteDomain = new ClienteDomain();
        clienteDomain.setId(1L);
        clienteDomain.setNome("Cliente Teste");

        atualizarClienteAdapter.atualizar(clienteDomain);

        ArgumentCaptor<ClienteEntity> captor = ArgumentCaptor.forClass(ClienteEntity.class);
        verify(clienteRepository, times(1)).save(captor.capture());

        ClienteEntity entitySalva = captor.getValue();
        assertEquals(clienteDomain.getId(), entitySalva.getId());
        assertEquals(clienteDomain.getNome(), entitySalva.getNome());
    }
}

