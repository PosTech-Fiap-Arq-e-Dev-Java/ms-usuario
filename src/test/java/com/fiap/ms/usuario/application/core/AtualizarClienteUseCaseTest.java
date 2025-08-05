package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizarClienteUseCaseTest {

    private BuscarClienteOutputPort buscarClienteOutputPort;
    private AtualizarClienteOutputPort atualizarClienteOutputPort;
    private ClienteValidatorHandler clienteValidatorHandler;

    private AtualizarClienteUseCase atualizarClienteUseCase;

    @BeforeEach
    void setUp() {
        buscarClienteOutputPort = mock(BuscarClienteOutputPort.class);
        atualizarClienteOutputPort = mock(AtualizarClienteOutputPort.class);
        clienteValidatorHandler = mock(ClienteValidatorHandler.class);

        atualizarClienteUseCase = new AtualizarClienteUseCase(
                buscarClienteOutputPort,
                atualizarClienteOutputPort,
                clienteValidatorHandler
        );
    }

    @Test
    void deveAtualizarClienteComSucesso() {
        String usuario = "cliente123";
        ClienteDomain novo = new ClienteDomain();
        novo.setNome("Novo Nome");
        novo.setEmail("novo@email.com");
        novo.setTelefone("999999999");
        novo.setEndereco("Rua Nova");

        ClienteDomain existente = new ClienteDomain();
        existente.setNome("Antigo Nome");
        existente.setEmail("antigo@email.com");
        existente.setTelefone("888888888");
        existente.setEndereco("Rua Antiga");

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarClienteUseCase.atualizar(usuario, novo);

        verify(clienteValidatorHandler).validarCamposObrigatoriosAtualizarCliente(novo);
        verify(clienteValidatorHandler).validarDadosIguaisCliente(novo, existente);
        verify(atualizarClienteOutputPort).atualizar(existente);

        assertEquals("Novo Nome", existente.getNome());
        assertEquals("novo@email.com", existente.getEmail());
        assertEquals("999999999", existente.getTelefone());
        assertEquals("Rua Nova", existente.getEndereco());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        String usuario = "cliente404";
        ClienteDomain novo = new ClienteDomain();

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException ex = assertThrows(UsuarioNaoEncontradoException.class,
                () -> atualizarClienteUseCase.atualizar(usuario, novo));

        assertTrue(ex.getMessage().contains("Usuário não encontrado"));
        assertTrue(ex.getMessage().contains(usuario));

        verify(atualizarClienteOutputPort, never()).atualizar(any());
    }

    @Test
    void deveChamarValidacaoDeCamposObrigatorios() {
        String usuario = "cliente123";
        ClienteDomain cliente = new ClienteDomain();

        ClienteDomain existente = new ClienteDomain();
        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarClienteUseCase.atualizar(usuario, cliente);

        verify(clienteValidatorHandler).validarCamposObrigatoriosAtualizarCliente(cliente);
    }

    @Test
    void naoDeveAtualizarQuandoDadosSaoIguais() {
        String usuario = "cliente123";
        ClienteDomain cliente = new ClienteDomain();
        cliente.setNome("João");
        cliente.setEmail("joao@email.com");
        cliente.setTelefone("123456789");
        cliente.setEndereco("Rua A");

        ClienteDomain existente = new ClienteDomain();
        existente.setNome("João");
        existente.setEmail("joao@email.com");
        existente.setTelefone("123456789");
        existente.setEndereco("Rua A");

        when(buscarClienteOutputPort.buscar(usuario)).thenReturn(Optional.of(existente));

        atualizarClienteUseCase.atualizar(usuario, cliente);

        verify(clienteValidatorHandler).validarDadosIguaisCliente(cliente, existente);
        verify(atualizarClienteOutputPort).atualizar(existente);
    }
}
