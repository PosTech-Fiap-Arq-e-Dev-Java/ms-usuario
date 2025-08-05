package com.fiap.ms.usuario.application.handler.impl;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.usuario.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.core.handler.impl.ClienteValidatorHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteValidatorHandlerImplTest {

    private ClienteValidatorHandlerImpl validator;

    @BeforeEach
    void setup() {
        validator = new ClienteValidatorHandlerImpl();
    }

    @Test
    void validarCamposObrigatoriosCliente_deveLancarQuandoCampoObrigatorioNuloOuVazio() {
        // Testa null
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(null));

        ClienteDomain cliente = new ClienteDomain();
        cliente.setEmail("  ");
        cliente.setTelefone("123");
        cliente.setNome("Nome");
        cliente.setEndereco("Endereco");
        cliente.setUsuario("usuario");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(cliente));

        cliente.setEmail("email@email.com");
        cliente.setTelefone(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(cliente));

        cliente.setTelefone("123");
        cliente.setNome("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(cliente));

        cliente.setNome("Nome");
        cliente.setEndereco(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(cliente));

        cliente.setEndereco("Endereco");
        cliente.setUsuario(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosCliente(cliente));
    }

    @Test
    void validarCamposObrigatoriosAtualizarCliente_deveLancarQuandoCampoObrigatorioNuloOuVazio() {
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarCliente(null));

        ClienteDomain cliente = new ClienteDomain();
        cliente.setEmail("  ");
        cliente.setTelefone("123");
        cliente.setNome("Nome");
        cliente.setEndereco("Endereco");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarCliente(cliente));

        cliente.setEmail("email@email.com");
        cliente.setTelefone(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarCliente(cliente));

        cliente.setTelefone("123");
        cliente.setNome("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarCliente(cliente));

        cliente.setNome("Nome");
        cliente.setEndereco(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarCliente(cliente));
    }

    @Test
    void validarDadosIguaisCliente_deveLancarQuandoDadosSaoIguais() {
        ClienteDomain novo = new ClienteDomain();
        novo.setEmail("Email@exemplo.com");
        novo.setTelefone("123");
        novo.setNome("Nome");
        novo.setEndereco("Endereco");
        novo.setUsuario("usuario");

        ClienteDomain existente = new ClienteDomain();
        existente.setEmail("email@EXEMPLO.com");
        existente.setTelefone("123");
        existente.setNome("nome");
        existente.setEndereco("endereco");
        existente.setUsuario("USUARIO");

        assertThrows(AtualizarDadosIguaisException.class, () -> validator.validarDadosIguaisCliente(novo, existente));
    }

    @Test
    void validarDadosIguaisCliente_naoDeveLancarQuandoDadosSaoDiferentes() {
        ClienteDomain novo = new ClienteDomain();
        novo.setEmail("email1@exemplo.com");
        novo.setTelefone("123");
        novo.setNome("Nome");
        novo.setEndereco("Endereco");
        novo.setUsuario("usuario");

        ClienteDomain existente = new ClienteDomain();
        existente.setEmail("email2@exemplo.com"); // diferente
        existente.setTelefone("123");
        existente.setNome("nome");
        existente.setEndereco("endereco");
        existente.setUsuario("usuario");

        assertDoesNotThrow(() -> validator.validarDadosIguaisCliente(novo, existente));
    }

    @Test
    void validarDadosIguaisCliente_deveTratarNullsCorretamente() {
        ClienteDomain novo = new ClienteDomain();
        novo.setEmail(null);
        novo.setTelefone(null);
        novo.setNome(null);
        novo.setEndereco(null);
        novo.setUsuario(null);

        ClienteDomain existente = new ClienteDomain();
        existente.setEmail(null);
        existente.setTelefone(null);
        existente.setNome(null);
        existente.setEndereco(null);
        existente.setUsuario(null);

        assertThrows(AtualizarDadosIguaisException.class, () -> validator.validarDadosIguaisCliente(novo, existente));

        existente.setEmail("email");
        assertDoesNotThrow(() -> validator.validarDadosIguaisCliente(novo, existente));
    }
}

