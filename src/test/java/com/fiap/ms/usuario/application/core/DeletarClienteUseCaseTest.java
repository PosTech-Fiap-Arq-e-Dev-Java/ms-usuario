package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarClienteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeletarClienteUseCaseTest {

    private BuscarClienteOutputPort buscarClienteOutputPort;
    private DeletarClienteOutputPort deletarClienteOutputPort;
    private DeletarClienteUseCase deletarClienteUseCase;

    @BeforeEach
    void setUp() {
        buscarClienteOutputPort = mock(BuscarClienteOutputPort.class);
        deletarClienteOutputPort = mock(DeletarClienteOutputPort.class);
        deletarClienteUseCase = new DeletarClienteUseCase(buscarClienteOutputPort, deletarClienteOutputPort);
    }

    @Test
    void deveDeletarClienteComSucesso() {
        String usuario = "cliente123";
        ClienteDomain cliente = new ClienteDomain();
        cliente.setUsuario(usuario);

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(cliente));

        deletarClienteUseCase.deletar(usuario);

        verify(buscarClienteOutputPort).buscar(usuario);
        verify(deletarClienteOutputPort).deletar(cliente);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        String usuario = "cliente404";

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException ex = assertThrows(UsuarioNaoEncontradoException.class,
                () -> deletarClienteUseCase.deletar(usuario));

        assertTrue(ex.getMessage().contains(usuario));

        verify(deletarClienteOutputPort, never()).deletar(any());
    }
}
