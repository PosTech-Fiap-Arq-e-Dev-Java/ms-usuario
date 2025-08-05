package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.AtualizarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizarRestauranteUseCaseTest {

    private BuscarRestauranteOutputPort buscarRestauranteOutputPort;
    private AtualizarRestauranteOutputPort atualizarRestauranteOutputPort;
    private RestauranteValidatorHandler restauranteValidatorHandler;
    private AtualizarRestauranteUseCase atualizarRestauranteUseCase;

    @BeforeEach
    void setUp() {
        buscarRestauranteOutputPort = mock(BuscarRestauranteOutputPort.class);
        atualizarRestauranteOutputPort = mock(AtualizarRestauranteOutputPort.class);
        restauranteValidatorHandler = mock(RestauranteValidatorHandler.class);

        atualizarRestauranteUseCase = new AtualizarRestauranteUseCase(
                buscarRestauranteOutputPort,
                atualizarRestauranteOutputPort,
                restauranteValidatorHandler
        );
    }

    @Test
    void deveAtualizarRestauranteComSucesso() {
        String usuario = "restaurante123";

        RestauranteDomain novo = new RestauranteDomain();
        novo.setNome("Novo Nome");
        novo.setEmail("novo@email.com");
        novo.setTelefone("999999999");
        novo.setEndereco("Rua Nova");
        novo.setHorarioFuncionamentoInicio("08:00");
        novo.setHorarioFuncionamentoFim("22:00");
        novo.setTipoCozinha("Italiana");
        novo.setDonoRestaurante(true);


        RestauranteDomain existente = new RestauranteDomain();
        existente.setNome("Antigo Nome");
        existente.setEmail("antigo@email.com");
        existente.setTelefone("888888888");
        existente.setEndereco("Rua Antiga");
        existente.setHorarioFuncionamentoInicio("07:00");
        existente.setHorarioFuncionamentoFim("21:00");
        existente.setTipoCozinha("Brasileira");
        existente.setDonoRestaurante(false);

        when(buscarRestauranteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarRestauranteUseCase.atualizar(usuario, novo);

        verify(restauranteValidatorHandler).validarCamposObrigatoriosAtualizarRestaurante(novo);
        verify(restauranteValidatorHandler).validarDadosIguaisRestaurante(novo, existente);
        verify(atualizarRestauranteOutputPort).atualizar(existente);

        assertEquals("Novo Nome", existente.getNome());
        assertEquals("novo@email.com", existente.getEmail());
        assertEquals("999999999", existente.getTelefone());
        assertEquals("Rua Nova", existente.getEndereco());
        assertEquals(Boolean.TRUE, existente.getDonoRestaurante());
        assertEquals("08:00", existente.getHorarioFuncionamentoInicio());
        assertEquals("22:00", existente.getHorarioFuncionamentoFim());
        assertEquals("Italiana", existente.getTipoCozinha());
    }

    @Test
    void deveLancarExcecaoQuandoRestauranteNaoEncontrado() {
        String usuario = "restaurante404";
        RestauranteDomain novo = new RestauranteDomain();

        when(buscarRestauranteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException ex = assertThrows(UsuarioNaoEncontradoException.class,
                () -> atualizarRestauranteUseCase.atualizar(usuario, novo));

        assertTrue(ex.getMessage().contains("Usuário não encontrado"));
        assertTrue(ex.getMessage().contains(usuario));

        verify(atualizarRestauranteOutputPort, never()).atualizar(any());
    }

    @Test
    void deveChamarValidacaoDeCamposObrigatorios() {
        String usuario = "restaurante123";
        RestauranteDomain domain = new RestauranteDomain();
        RestauranteDomain existente = new RestauranteDomain();

        when(buscarRestauranteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarRestauranteUseCase.atualizar(usuario, domain);

        verify(restauranteValidatorHandler).validarCamposObrigatoriosAtualizarRestaurante(domain);
    }

    @Test
    void deveChamarValidarDadosIguais() {
        String usuario = "restaurante123";

        RestauranteDomain domain = new RestauranteDomain();
        RestauranteDomain existente = new RestauranteDomain();

        when(buscarRestauranteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarRestauranteUseCase.atualizar(usuario, domain);

        verify(restauranteValidatorHandler).validarDadosIguaisRestaurante(domain, existente);
    }
}
