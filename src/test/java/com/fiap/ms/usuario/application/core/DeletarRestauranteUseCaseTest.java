package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarRestauranteOutputPort;
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
public class DeletarRestauranteUseCaseTest {

    @Mock
    private BuscarRestauranteOutputPort buscarRestauranteOutputPort;

    @Mock
    private DeletarRestauranteOutputPort deletarRestauranteOutputPort;

    @InjectMocks
    private DeletarRestauranteUseCase deletarRestauranteUseCase;

    @Test
    void deveDeletarUsuarioQuandoEncontrado() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();

        when(buscarRestauranteOutputPort.buscar(usuarioDomain.getUsuario())).thenReturn(Optional.of(usuarioDomain));

        deletarRestauranteUseCase.deletar(usuarioDomain.getUsuario());

        verify(deletarRestauranteOutputPort).deletar(usuarioDomain);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        String usuario = "naoexiste";

        when(buscarRestauranteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        assertThrows(UsuarioNaoEncontradoException.class,
                () -> deletarRestauranteUseCase.deletar(usuario)
        );

        verifyNoInteractions(deletarRestauranteOutputPort);
    }
}
