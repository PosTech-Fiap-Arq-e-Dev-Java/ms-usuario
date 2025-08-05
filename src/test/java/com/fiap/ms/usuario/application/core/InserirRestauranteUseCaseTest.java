package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InserirRestauranteUseCaseTest {

    private InserirRestauranteOutputPort inserirRestauranteOutputPort;
    private BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private RestauranteValidatorHandler restauranteValidatorHandler;
    private InserirRestauranteUseCase inserirRestauranteUseCase;

    @BeforeEach
    void setUp() {
        inserirRestauranteOutputPort = mock(InserirRestauranteOutputPort.class);
        buscarRestauranteOutputPort = mock(BuscarRestauranteOutputPort.class);
        restauranteValidatorHandler = mock(RestauranteValidatorHandler.class);

        inserirRestauranteUseCase = new InserirRestauranteUseCase(
                inserirRestauranteOutputPort,
                buscarRestauranteOutputPort,
                restauranteValidatorHandler
        );
    }

    @Test
    void deveInserirRestauranteComSucesso() {
        RestauranteDomain restaurante = new RestauranteDomain();
        restaurante.setUsuario("restaurante1");
        restaurante.setTelefone("123456789");
        restaurante.setEmail("restaurante1@email.com");

        when(buscarRestauranteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                restaurante.getUsuario(), restaurante.getTelefone(), restaurante.getEmail()))
                .thenReturn(Optional.empty());

        inserirRestauranteUseCase.inserir(restaurante);

        verify(restauranteValidatorHandler).validarCamposObrigatoriosRestaurante(restaurante);
        verify(inserirRestauranteOutputPort).inserir(restaurante);
    }

    @Test
    void deveLancarExcecaoQuandoRestauranteJaExistente() {
        RestauranteDomain restaurante = new RestauranteDomain();
        restaurante.setUsuario("restauranteExistente");
        restaurante.setTelefone("999999999");
        restaurante.setEmail("existente@email.com");

        when(buscarRestauranteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                restaurante.getUsuario(), restaurante.getTelefone(), restaurante.getEmail()))
                .thenReturn(Optional.of(restaurante));

        assertThrows(UsuarioJaExistenteException.class, () -> inserirRestauranteUseCase.inserir(restaurante));

        verify(restauranteValidatorHandler).validarCamposObrigatoriosRestaurante(restaurante);
        verify(inserirRestauranteOutputPort, never()).inserir(any());
    }
}
