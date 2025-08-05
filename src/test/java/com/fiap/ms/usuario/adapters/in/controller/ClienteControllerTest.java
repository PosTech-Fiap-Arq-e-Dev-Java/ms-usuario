package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.ClienteDtoMapper;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.ports.in.*;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarClienteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.ClienteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Mock
    private InserirClienteInputPort inserirClienteInputPort;

    @Mock
    private BuscarClienteInputPort buscarClienteInputPort;

    @Mock
    private DeletarClienteInputPort deletarClienteInputPort;

    @Mock
    private AtualizarClienteInputPort atualizarClienteInputPort;

    @Mock
    private ClienteDtoMapper clienteDtoMapper;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarClienteComSucesso() {
        String usuario = "cliente123";

        ClienteDomain clienteDomain = new ClienteDomain();
        ClienteDto clienteDto = new ClienteDto();

        when(buscarClienteInputPort.buscar(usuario)).thenReturn(clienteDomain);
        when(clienteDtoMapper.toClienteDto(clienteDomain)).thenReturn(clienteDto);

        ResponseEntity<?> response = clienteController._buscarCliente(usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());

        verify(buscarClienteInputPort).buscar(usuario);
        verify(clienteDtoMapper).toClienteDto(clienteDomain);
    }

    @Test
    void deveInserirClienteComSucesso() {
        ClienteDto clienteDto = new ClienteDto();
        ClienteDomain clienteDomain = new ClienteDomain();

        when(clienteDtoMapper.toClienteDomain(clienteDto)).thenReturn(clienteDomain);

        ResponseEntity<Void> response = clienteController._inserirCliente(clienteDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNull(response.getBody());

        verify(clienteDtoMapper).toClienteDomain(clienteDto);
        verify(inserirClienteInputPort).inserir(clienteDomain);
    }

    @Test
    void deveAtualizarClienteComSucesso() {
        String usuario = "cliente123";
        AtualizarClienteRequestDto atualizarDto = new AtualizarClienteRequestDto();
        ClienteDomain clienteDomain = new ClienteDomain();

        when(clienteDtoMapper.toClienteDomainUpdate(atualizarDto)).thenReturn(clienteDomain);

        ResponseEntity<ClienteDto> response = clienteController._atualizarCliente(usuario, atualizarDto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        verify(clienteDtoMapper).toClienteDomainUpdate(atualizarDto);
        verify(atualizarClienteInputPort).atualizar(usuario, clienteDomain);
    }

    @Test
    void deveDeletarClienteComSucesso() {
        String usuario = "cliente123";

        ResponseEntity<Void> response = clienteController._deletarCliente(usuario);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        verify(deletarClienteInputPort).deletar(usuario);
    }
}

