package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.Usuario;

import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarUsuarioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DeletarUsuarioUseCaseTest {

    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private DeletarUsuarioOutputPort deletarUsuarioOutputPort;
    private DeletarUsuarioUseCase deletarUsuarioUseCase;

    @BeforeEach
    void setUp() {
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        deletarUsuarioOutputPort = mock(DeletarUsuarioOutputPort.class);
        deletarUsuarioUseCase = new DeletarUsuarioUseCase(buscarUsuarioOutputPort, deletarUsuarioOutputPort);
    }

    @Test
    void testDeletarUsuarioExistente() {
        String login = "admin";
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setLogin(login);

        when(buscarUsuarioOutputPort.buscarPorLogin(login)).thenReturn(usuario);

        deletarUsuarioUseCase.deletarPorLogin(login);

        verify(buscarUsuarioOutputPort, times(1)).buscarPorLogin(login);
        verify(deletarUsuarioOutputPort, times(1)).deletarPorId(1L);
    }

    @Test
    void testDeletarUsuarioInexistente() {
        String login = "inexistente";
        when(buscarUsuarioOutputPort.buscarPorLogin(login)).thenReturn(null);

        UsuarioNaoEncontradoException exception = assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> deletarUsuarioUseCase.deletarPorLogin(login)
        );

        assertEquals("Usuário com login 'inexistente' não encontrado.", exception.getMessage());
        verify(buscarUsuarioOutputPort, times(1)).buscarPorLogin(login);
    }
}

