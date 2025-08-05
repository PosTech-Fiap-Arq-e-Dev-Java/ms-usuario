package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomainAtualizado;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtualizarClienteUseCaseTest {

   /* @Mock
    private BuscarClienteOutputPort buscarClienteOutputPort;

    @Mock
    private AtualizarClienteOutputPort atualizarClienteOutputPort;

    @Mock
    private RestauranteValidatorHandler usuarioValidatorHandler;

    @InjectMocks
    private AtualizarClienteUseCase atualizarClienteUseCase;

    @Test
    void deveAtualizarRestauranteQuandoValido() {
        RestauranteDomain existente = getUsuarioDomain();
        RestauranteDomain novo = getUsuarioDomainAtualizado();

        when(buscarClienteOutputPort.buscar(existente.getUsuario()))
                .thenReturn(Optional.of(existente));

        atualizarClienteUseCase.atualizar(existente.getUsuario(), novo);

        verify(usuarioValidatorHandler).validarCamposObrigatoriosAtualizarUsuario(novo);
        verify(usuarioValidatorHandler).validarDadosIguaisUsuario(novo, existente);

        verify(atualizarClienteOutputPort).atualizar(existente);

        assertEquals(novo.getNome(), existente.getNome());
        assertEquals(novo.getEmail(), existente.getEmail());
        assertEquals(novo.getTelefone(), existente.getTelefone());
        assertEquals(novo.getEndereco(), existente.getEndereco());
    }

    @Test
    void deveLancarExcecaoQuandoRestauranteNaoForEncontrado() {
        String usuario = "naoexiste";
        RestauranteDomain usuarioDomain = new RestauranteDomain();

        when(buscarClienteOutputPort.buscar(usuario))
                .thenReturn(Optional.empty());

        UsuarioNaoEncontradoException exception = assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> atualizarClienteUseCase.atualizar(usuario, usuarioDomain)
        );

        assertTrue(exception.getMessage().contains(usuario));

        verifyNoInteractions(atualizarClienteOutputPort);
    }

    @Test
    void deveLancarErroQuandoDadosForemIguais() {
        String usuario = "restaurante";
        RestauranteDomain usuarioDomain = new RestauranteDomain();
        RestauranteDomain existente = new RestauranteDomain();

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        doThrow(new IllegalArgumentException("Dados iguais"))
                .when(usuarioValidatorHandler).validarDadosIguaisUsuario(usuarioDomain, existente);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> atualizarClienteUseCase.atualizar(usuario, usuarioDomain));

        assertEquals("Dados iguais", ex.getMessage());
        verifyNoInteractions(atualizarClienteOutputPort);
    }

    */
}
