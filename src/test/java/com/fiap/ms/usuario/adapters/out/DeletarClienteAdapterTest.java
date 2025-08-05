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

class DeletarClienteAdapterTest {

    private ClienteRepository clienteRepository;
    private DeletarClienteAdapter deletarClienteAdapter;

    @BeforeEach
    void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        deletarClienteAdapter = new DeletarClienteAdapter(clienteRepository);
    }

    @Test
    void deveChamarDeleteComEntidadeCorreta() {
        ClienteDomain clienteDomain = new ClienteDomain();
        clienteDomain.setId(1L);
        clienteDomain.setNome("Cliente Teste");
        clienteDomain.setUsuario("cliente123");

        ClienteEntity entityEsperada = ClienteEntityMapper.INSTANCE.toClienteEntity(clienteDomain);

        deletarClienteAdapter.deletar(clienteDomain);


        ArgumentCaptor<ClienteEntity> captor = ArgumentCaptor.forClass(ClienteEntity.class);
        verify(clienteRepository, times(1)).delete(captor.capture());

        ClienteEntity entityRecebida = captor.getValue();
        assertEquals(entityEsperada.getId(), entityRecebida.getId());
        assertEquals(entityEsperada.getUsuario(), entityRecebida.getUsuario());
        assertEquals(entityEsperada.getNome(), entityRecebida.getNome());
    }
}

