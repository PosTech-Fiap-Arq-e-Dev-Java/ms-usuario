package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarClienteUseCaseTest {

    private BuscarClienteOutputPort buscarClienteOutputPort;
    private BuscarClienteUseCase buscarClienteUseCase;

    @BeforeEach
    void setUp() {
        buscarClienteOutputPort = mock(BuscarClienteOutputPort.class);
        buscarClienteUseCase = new BuscarClienteUseCase(buscarClienteOutputPort);
    }

    @Test
    void deveRetornarClienteQuandoEncontrado() {
        String usuario = "cliente123";
        ClienteDomain cliente = new ClienteDomain();
        cliente.setUsuario(usuario);
        cliente.setNome("Cliente Teste");

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(cliente));

        ClienteDomain resultado = buscarClienteUseCase.buscar(usuario);

        assertNotNull(resultado);
        assertEquals(usuario, resultado.getUsuario());
        assertEquals("Cliente Teste", resultado.getNome());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        String usuario = "cliente404";

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException ex = assertThrows(UsuarioNaoEncontradoException.class,
                () -> buscarClienteUseCase.buscar(usuario));

        assertTrue(ex.getMessage().contains(usuario));
    }
}

