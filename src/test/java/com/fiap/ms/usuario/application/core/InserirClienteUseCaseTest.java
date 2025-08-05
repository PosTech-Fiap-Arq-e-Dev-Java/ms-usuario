package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InserirClienteUseCaseTest {

    private InserirClienteOutputPort inserirClienteOutputPort;
    private BuscarClienteOutputPort buscarClienteOutputPort;
    private ClienteValidatorHandler clienteValidatorHandler;
    private InserirClienteUseCase inserirClienteUseCase;

    @BeforeEach
    void setUp() {
        inserirClienteOutputPort = mock(InserirClienteOutputPort.class);
        buscarClienteOutputPort = mock(BuscarClienteOutputPort.class);
        clienteValidatorHandler = mock(ClienteValidatorHandler.class);

        inserirClienteUseCase = new InserirClienteUseCase(
                inserirClienteOutputPort,
                buscarClienteOutputPort,
                clienteValidatorHandler
        );
    }

    @Test
    void deveInserirClienteComSucesso() {
        ClienteDomain cliente = new ClienteDomain();
        cliente.setUsuario("cliente1");
        cliente.setTelefone("123456789");
        cliente.setEmail("cliente1@email.com");

        when(buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                cliente.getUsuario(), cliente.getTelefone(), cliente.getEmail()))
                .thenReturn(Optional.empty());

        inserirClienteUseCase.inserir(cliente);

        verify(clienteValidatorHandler).validarCamposObrigatoriosCliente(cliente);
        verify(inserirClienteOutputPort).inserir(cliente);
    }

    @Test
    void deveLancarExcecaoQuandoClienteJaExistente() {
        ClienteDomain cliente = new ClienteDomain();
        cliente.setUsuario("clienteExistente");
        cliente.setTelefone("999999999");
        cliente.setEmail("existente@email.com");

        when(buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                cliente.getUsuario(), cliente.getTelefone(), cliente.getEmail()))
                .thenReturn(Optional.of(cliente));

        assertThrows(UsuarioJaExistenteException.class, () -> inserirClienteUseCase.inserir(cliente));

        verify(clienteValidatorHandler).validarCamposObrigatoriosCliente(cliente);
        verify(inserirClienteOutputPort, never()).inserir(any());
    }
}
