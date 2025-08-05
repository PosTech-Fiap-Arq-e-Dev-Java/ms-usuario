package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.ClienteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InserirClienteAdapterTest {

    private ClienteRepository clienteRepository;
    private InserirClienteAdapter inserirClienteAdapter;

    @BeforeEach
    void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        inserirClienteAdapter = new InserirClienteAdapter(clienteRepository);
    }

    @Test
    void deveChamarSaveComEntidadeCorreta() {
        ClienteDomain clienteDomain = new ClienteDomain();
        clienteDomain.setId(1L);
        clienteDomain.setNome("Cliente Teste");
        clienteDomain.setUsuario("cliente123");

        ClienteEntity clienteEntityEsperado = ClienteEntityMapper.INSTANCE.toClienteEntity(clienteDomain);

        inserirClienteAdapter.inserir(clienteDomain);

        ArgumentCaptor<ClienteEntity> captor = ArgumentCaptor.forClass(ClienteEntity.class);
        verify(clienteRepository, times(1)).save(captor.capture());

        ClienteEntity capturado = captor.getValue();
        assertEquals(clienteEntityEsperado.getId(), capturado.getId());
        assertEquals(clienteEntityEsperado.getNome(), capturado.getNome());
        assertEquals(clienteEntityEsperado.getUsuario(), capturado.getUsuario());
    }
}

