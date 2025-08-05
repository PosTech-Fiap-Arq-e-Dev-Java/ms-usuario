package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarClienteOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarClienteUseCaseTest {
/*
    @Mock
    private BuscarClienteOutputPort buscarClienteOutputPort;

    @Mock
    private DeletarClienteOutputPort deletarClienteOutputPort;

    @InjectMocks
    private DeletarClienteUseCase deletarClienteUseCase;

    @Test
    void deveDeletarUsuarioQuandoEncontrado() {
        RestauranteDomain usuarioDomain = getUsuarioDomain();

        when(buscarClienteOutputPort.buscar(usuarioDomain.getUsuario())).thenReturn(Optional.of(usuarioDomain));

        deletarClienteUseCase.deletar(usuarioDomain.getUsuario());

        verify(deletarClienteOutputPort).deletar(usuarioDomain);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        String usuario = "naoexiste";

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        assertThrows(UsuarioNaoEncontradoException.class,
                () -> deletarClienteUseCase.deletar(usuario)
        );

        verifyNoInteractions(deletarClienteOutputPort);
    }

 */
}
