package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarClienteUseCaseTest {
/*
    @Mock
    private BuscarClienteOutputPort buscarClienteOutputPort;

    @InjectMocks
    private BuscarClienteUseCase buscarClienteUseCase;

    @Test
    void deveRetornarUsuarioQuandoEncontrado() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();

        when(buscarClienteOutputPort.buscar(usuarioDomain.getUsuario()))
                .thenReturn(Optional.of(usuarioDomain));

        RestauranteDomain resultado = buscarClienteUseCase.buscar(usuarioDomain.getUsuario());

        assertNotNull(resultado);
        assertEquals(usuarioDomain.getUsuario(), resultado.getUsuario());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        String usuario = "inexistente";

        when(buscarClienteOutputPort.buscar(usuario))
                .thenReturn(Optional.empty());

        UsuarioNaoEncontradoException exception = assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> buscarClienteUseCase.buscar(usuario)
        );

        assertTrue(exception.getMessage().contains("Usuário não encontrado"));
        assertTrue(exception.getMessage().contains(usuario));
    }

 */
}
